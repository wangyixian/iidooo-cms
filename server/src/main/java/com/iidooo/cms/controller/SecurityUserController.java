package com.iidooo.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.model.vo.SecurityUserInfo;
import com.iidooo.cms.service.SecurityUserService;
import com.iidooo.core.enums.MessageCode;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.util.StringUtil;

@Controller
public class SecurityUserController {
    private static final Logger logger = Logger.getLogger(SecurityUserController.class);

    @Autowired
    private SecurityUserService securityUserService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String userID = request.getParameter("userID");
            if (StringUtil.isBlank(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageCode.FieldRequired, MessageType.ERROR, "userID");
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
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageCode.Exception, MessageType.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }

    @RequestMapping(value = "/createDefaultUser", method = RequestMethod.POST)
    public @ResponseBody ResponseResult createDefaultUser(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String photoBaseURL = StringUtil.getRequestBaseURL(request.getRequestURL().toString(), request.getServletPath());
            SecurityUserInfo userInfo = this.securityUserService.createDefaultUser(photoBaseURL);
            if (userInfo == null) {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(userInfo);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageCode.Exception, MessageType.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public @ResponseBody ResponseResult updateUserInfo(@RequestBody SecurityUserInfo user) {
        ResponseResult result = new ResponseResult();
        try {
            SecurityUserInfo userInfo = this.securityUserService.updateUserInfo(user);
            if (userInfo == null) {
                result.setStatus(ResponseStatus.UpdateFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(userInfo);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageCode.Exception, MessageType.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }
}
