package com.iidooo.cms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.enums.TableName;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.model.vo.SecurityUserInfo;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.service.SecurityUserService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.MailUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class SecurityUserController {
    private static final Logger logger = Logger.getLogger(SecurityUserController.class);

    // key: email
    // value: verfy code
    Map<String, String> verifyCodeMap = new HashMap<>();

    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String userID = request.getParameter("userID");
            if (StringUtil.isBlank(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            SecurityUserInfo userInfo = this.securityUserService.getUserInfoByID(Integer.valueOf(userID));
            if (userInfo == null) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(userInfo);
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.SECURITY_USER.toString(), userInfo.getUserID(), request);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }

    @RequestMapping(value = "/createDefaultUser", method = RequestMethod.POST)
    public @ResponseBody ResponseResult createDefaultUser(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String photoBaseURL = StringUtil.getRequestBaseURL(request.getRequestURL().toString(), request.getServletPath());
            SecurityUserInfo userInfo = this.securityUserService.createDefaultUser(photoBaseURL + "/resources/upload/img/photo/default.png");
            if (userInfo == null) {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(userInfo);
            }

            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.SECURITY_USER.toString(), userInfo.getUserID(), request);

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public @ResponseBody ResponseResult updateUserInfo(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            SecurityUserInfo userInfo = new SecurityUserInfo();

            String userID = request.getParameter("userID");
            String userName = request.getParameter("userName");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String verifyCode = request.getParameter("verifyCode");
            String sex = request.getParameter("sex");
            String birthday = request.getParameter("birthday");
            String weixinID = request.getParameter("weixinID");
            String photoURL = request.getParameter("photoURL");
            String isSilent = request.getParameter("isSilent");
            String isDisable = request.getParameter("isDisable");

            if (StringUtil.isBlank(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            userInfo.setUserID(Integer.parseInt(userID));
            userInfo.setUserName(userName);
            userInfo.setMobile(mobile);

            if (StringUtil.isNotBlank(email)) {
                if (StringUtil.isBlank(verifyCode) || !verifyCodeMap.containsKey(email)) {
                    // 验证失败，返回message
                    Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "verifyCode");
                    result.getMessages().add(message);
                    result.setStatus(ResponseStatus.Failed.getCode());
                    return result;
                } else {
                    // 邮件验证码确认成功
                    userInfo.setEmail(email);
                    verifyCodeMap.remove(email);
                }
            }

            userInfo.setSex(sex);
            if (StringUtil.isNotBlank(birthday)) {
                Date birthdayDate = DateUtil.parseToDate(birthday, DateUtil.DATE_HYPHEN);
                userInfo.setBirthday(birthdayDate);
            }
            userInfo.setWeixinID(weixinID);
            userInfo.setPhotoURL(photoURL);
            if (StringUtil.isNotBlank(isSilent) && ValidateUtil.isNumber(isSilent)) {
                userInfo.setIsSilent(Integer.parseInt(isSilent));
            }
            if (StringUtil.isNotBlank(isDisable) && ValidateUtil.isNumber(isDisable)) {
                userInfo.setIsDisable(Integer.parseInt(isDisable));
            }

            userInfo = this.securityUserService.updateUserInfo(userInfo);
            if (userInfo == null) {
                result.setStatus(ResponseStatus.UpdateFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(userInfo);
            }

            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.SECURITY_USER.toString(), userInfo.getUserID(), request);

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }

    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.POST)
    public @ResponseBody ResponseResult sendVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String email = request.getParameter("email");

            if (StringUtil.isBlank(email)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "email");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isEmail(email)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "email");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            String verifyCode = StringUtil.getRandomNumber(4);
            this.verifyCodeMap.put(email, verifyCode);

            ServletContext sc = request.getServletContext();
            Properties mailProperties = (Properties) sc.getAttribute("mail.properties");

            String content = "【毒电波】亲爱的用户，您本次绑定邮箱用的验证码是：" + verifyCode;
            if (!MailUtil.sendMail(mailProperties, content, email)) {
                result.setStatus(ResponseStatus.Failed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }
}
