/**
 * Copyright 2014-2015 IIDOOO All rights reserved.
 * Author(e-mail)    wangyixian@iidooo.com
 * Creation date     2015-03-27
 */
package com.iidooo.cms.action.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.iidooo.cms.service.system.LoginService;
import com.iidooo.cms.service.system.impl.LoginServiceImpl;
import com.iidooo.core.action.BaseLoginAction;
import com.iidooo.core.constant.SessionConstant;
import com.iidooo.core.dto.extend.SecurityResDto;
import com.iidooo.core.dto.extend.SecurityRoleDto;
import com.iidooo.core.dto.extend.SecurityUserDto;
import com.iidooo.core.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;

/**
 * The Action of execute login operation.
 * 
 * @author Ethan
 *
 */
public class LoginAction extends BaseLoginAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(LoginAction.class);

    private LoginService loginService;

    private String loginID;

    private String password;

    // private String identifyCode;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public String getIdentifyCode() {
    // return identifyCode;
    // }
    //
    // public void setIdentifyCode(String identifyCode) {
    // this.identifyCode = identifyCode;
    // }

    public LoginAction() {
        this.loginService = new LoginServiceImpl();
    }

    public String login() {
        try {

            HttpServletResponse response = this.getResponse();
            HttpServletRequest request = this.getRequest();
            Map<String, Object> sessionMap = this.getSession();

            // 用户登录
            SecurityUserDto user = loginService.login(loginID, password);
            if (user == null) {
                addActionError(getText("MSG_LOGIN_FAILED"));
                return INPUT;
            }

            // 保存登录用户进session
            sessionMap.put(SessionConstant.LOGIN_USER, user);

            // 保存该用户角色一览进session
            List<SecurityRoleDto> roleList = loginService.getUserRoleList(user.getUserID());
            sessionMap.put(SessionConstant.LOGIN_ROLE_LIST, roleList);

            // 保存该角色能访问的资源一览
            List<SecurityResDto> resourceList = loginService.getUserResourceList(roleList);
            sessionMap.put(SessionConstant.LOGIN_RESOURCE_LIST, resourceList);
            List<String> resourceURLList = new ArrayList<String>();
            for (SecurityResDto resourceDto : resourceList) {
                resourceURLList.add(resourceDto.getResURL());
            }
            sessionMap.put(SessionConstant.LOGIN_RESOURCE_URL_LIST, resourceURLList);

//            // Add the login ID into the cookie for SSO
//            // Set the Login ID into the cookie
//            Cookie cookieLoginID = new Cookie(SessionConstant.LOGIN_ID, user.getLoginID());
//            cookieLoginID.setPath("/");
//            // - value mean the cookie will be delete when browse closed.
//            cookieLoginID.setMaxAge(-1);
//            response.addCookie(cookieLoginID);
//
//            // Set the User ID into the cookie
//            Cookie cookieUserID = new Cookie(SessionConstant.USER_ID, user.getUserID().toString());
//            cookieUserID.setPath("/");
//            // - value mean the cookie will be delete when browse closed.
//            cookieUserID.setMaxAge(-1);
//            response.addCookie(cookieUserID);
//
//            // Set the user name into the cookie
//            String userName = user.getUserName();
//            Cookie cookieUserName = new Cookie(SessionConstant.USER_NAME, URLEncoder.encode(userName, HttpConstant.CHARACTER_ENCODING_UTF8));
//            cookieUserName.setPath("/");
//            cookieUserName.setMaxAge(-1);
//            response.addCookie(cookieUserName);


            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateLogin() {
        try {
            // 验证用户名／密码是否为空
            if (StringUtil.isBlank(loginID.trim())) {
                addFieldError("loginID", getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_LOGIN_ID") }));
            }

            if (StringUtil.isBlank(password.trim())) {
                addFieldError("password", getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_LOGIN_PASSWORD") }));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public String logout() {
        try {
            // When logout the system, should delete the session.
            ActionContext actionContext = ActionContext.getContext();
            actionContext.getSession().clear();

            // When logout the system, should delete the cookies.
            HttpServletResponse response = ServletActionContext.getResponse();
            HttpServletRequest request = ServletActionContext.getRequest();
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                // Set the 0 mean delete the cookies.
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
