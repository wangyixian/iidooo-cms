package com.iidooo.cms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.enums.ContentType;
import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.vo.SecurityUserInfo;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.constant.ServletConstant;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.UserType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.model.po.SecurityAccessToken;
import com.iidooo.core.model.po.SecurityResource;
import com.iidooo.core.model.po.SecurityRole;
import com.iidooo.core.model.po.SecurityUser;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.service.SecurityUserService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.MailUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class CmsUserController {
    private static final Logger logger = Logger.getLogger(CmsUserController.class);

    // key: email
    // value: verfy code
    Map<String, String> verifyCodeMap = new HashMap<>();
    
    private long FIVE_MINUTE = 5 * 60 * 1000;

    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @ResponseBody
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseResult getUserInfo(HttpServletRequest request, HttpServletResponse response) {
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

            SecurityUser securityUser = this.securityUserService.getSecurityUserByID(Integer.valueOf(userID));
            if (securityUser == null) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                // 设置用户内容总数
                SecurityUserInfo securityUserInfo = new SecurityUserInfo(securityUser);
                int contentCount = contentService.getUserContentCount(securityUser.getUserID(), ContentType.Default.getCode());
                securityUserInfo.setContentCount(contentCount);

                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(securityUserInfo);
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

    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getUserByEmail(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            ServletContext sc = request.getServletContext();
            Properties properties = (Properties) sc.getAttribute("random_name.properties");

            String email = request.getParameter("email");
            String verifyCode = request.getParameter("verifyCode");

            if (StringUtil.isBlank(email)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                message.setDescription("The field of userID is required.");
                result.getMessages().add(message);
            }
            if (StringUtil.isBlank(verifyCode) || !verifyCodeMap.containsKey(email)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "verifyCode");
                message.setDescription("The field of verifyCode is required.");
                result.getMessages().add(message);
            } else if (!verifyCodeMap.get(email).equals(verifyCode)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "verifyCode");
                message.setDescription("This email's verify code is wrong.");
                result.getMessages().add(message);
            }

            if (result.getMessages().size() > 0) {
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            verifyCodeMap.remove(email);

            SecurityUser securityUser = securityUserService.getSecurityUserByEmail(email);
            if (securityUser == null) {

                Properties aliyunProperties = (Properties) sc.getAttribute("aliyun.properties");
                String photoBaseURL = aliyunProperties.getProperty("ALIYUN_OSS_DOMAIN");
                String photoPath = StringUtil.replace(CmsConstant.DEFAULT_PHOTO_URL, StringUtil.getRandomNumber(1, 4));
                securityUser = securityUserService.createDefaultUser(photoBaseURL + photoPath, email, properties);
            }
            
            if (securityUser == null) {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
            } else {
                // 设置用户内容总数
                SecurityUserInfo securityUserInfo = new SecurityUserInfo(securityUser);
                int contentCount = contentService.getUserContentCount(securityUser.getUserID(), ContentType.News.getCode());
                securityUserInfo.setContentCount(contentCount);
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(securityUserInfo);
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.SECURITY_USER.toString(), securityUser.getUserID(), request);
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
            ServletContext sc = request.getServletContext();
            Properties properties = (Properties) sc.getAttribute("random_name.properties");

            Properties aliyunProperties = (Properties) sc.getAttribute("aliyun.properties");
            String photoBaseURL = aliyunProperties.getProperty("ALIYUN_OSS_DOMAIN");
            String photoPath = StringUtil.replace(CmsConstant.DEFAULT_PHOTO_URL, StringUtil.getRandomNumber(1, 4));
            SecurityUser userInfo = this.securityUserService.createDefaultUser(photoBaseURL + photoPath, "", properties);
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
            SecurityUser userInfo = new SecurityUser();

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
                System.out.println(email);
                System.out.println(verifyCode);
                if (StringUtil.isBlank(verifyCode) || !verifyCodeMap.containsKey(email)) {
                    // 验证失败，返回message
                    Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "verifyCode");
                    result.getMessages().add(message);
                    result.setStatus(ResponseStatus.Failed.getCode());
                    return result;
                } else if (!verifyCodeMap.get(email).equals(verifyCode)) {
                    // 验证失败，返回message
                    Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "verifyCode");
                    result.getMessages().add(message);
                    result.setStatus(ResponseStatus.ConfinedFailed.getCode());
                    return result;
                } else {
                    // 邮件验证码确认成功
                    userInfo.setEmail(email);
                    verifyCodeMap.remove(email);

                    SecurityUser securityUser = securityUserService.getSecurityUserByEmail(email);
                    if (securityUser != null && securityUser.getUserID() != userInfo.getUserID()) {
                        // 验证失败，返回message
                        Message message = new Message(MessageType.FieldDuplicate.getCode(), MessageLevel.ERROR, "email");
                        message.setDescription("The setting email is duplicated.");
                        result.getMessages().add(message);
                        result.setStatus(ResponseStatus.DuplicateFailed.getCode());
                        return result;
                    }
                }
            } else {
                // 更新用户，用户名不能设置为空
                if (StringUtil.isBlank(userName)) {
                    // 验证失败，返回message
                    Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userName");
                    result.getMessages().add(message);
                    result.setStatus(ResponseStatus.Failed.getCode());
                    return result;
                }
            }

            userInfo.setSex(sex);
            if (StringUtil.isNotBlank(birthday)) {
                Date birthdayDate = DateUtil.getDate(birthday, DateUtil.DATE_HYPHEN);
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

    @RequestMapping(value = "/updateUserExp", method = RequestMethod.POST)
    public @ResponseBody ResponseResult updateUserExp(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String userIDStr = request.getParameter("userID");
            String experienceStr = request.getParameter("experience");
            // 是否是受每日经验限定的Flag
            String isLimitedStr = request.getParameter("isLimited");

            if (StringUtil.isBlank(userIDStr)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(userIDStr)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
            }

            if (StringUtil.isBlank(experienceStr)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "experience");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(experienceStr)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "experience");
                result.getMessages().add(message);
            }

            if (result.getMessages().size() > 0) {
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            if (StringUtil.isBlank(isLimitedStr) || !ValidateUtil.isNumber(isLimitedStr)) {
                isLimitedStr = "1";
            }

            int userID = Integer.parseInt(userIDStr);
            int experience = Integer.parseInt(experienceStr);
            int isLimited = Integer.parseInt(isLimitedStr);

            SecurityUser userInfo = this.securityUserService.updateUserExp(userID, experience, isLimited);
            if (userInfo == null) {
                Message message = new Message(MessageType.Information.getCode(), MessageLevel.INFO);
                message.setDescription("The user's exp is more than limited of today!");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.OK.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(userInfo);
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

            String verifyCode = StringUtil.getRandomNumber(4, 9);
            this.verifyCodeMap.put(email, verifyCode);

            ServletContext sc = request.getServletContext();
            Properties mailProperties = (Properties) sc.getAttribute("mail.properties");

            String content = "亲爱的用户，" + verifyCode + " 是您的验证码，5分钟内有效。";
            if (!MailUtil.sendMail(mailProperties, content, email)) {
                result.setStatus(ResponseStatus.Failed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                verifyCodeTimeTask(email);
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
    
    private void verifyCodeTimeTask(final String account) {

        new Thread() {
            public void run() {

                TimerTask task = new TimerTask() {
                    public void run() {
                        verifyCodeMap.remove(account);
                    }
                };

                Timer timer = new Timer(false);
                timer.schedule(task, FIVE_MINUTE);
                /*
                 * try { Thread.sleep(FIVE_MINUTE + 1000); } catch
                 * (InterruptedException e) { logger.info("验证码计时异常",e); }
                 */
            }
        }.start();
    }
}
