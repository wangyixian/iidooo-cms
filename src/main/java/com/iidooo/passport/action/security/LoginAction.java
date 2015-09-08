/**
 * Copyright 2014-2015 IIDOOO All rights reserved.
 * Author(e-mail)    wangyixian@iidooo.com
 * Creation date     2015-03-27
 */
package com.iidooo.passport.action.security;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.ResourceDto;
import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.security.LoginService;
import com.opensymphony.xwork2.ActionContext;

/**
 * The Action of execute login operation.
 * 
 * @author Ethan
 *
 */
public class LoginAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(LoginAction.class);

    @Autowired
    private LoginService loginService;

    private String loginID;

    private String password;
    
    //private String identifyCode;

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

//    public String getIdentifyCode() {
//        return identifyCode;
//    }
//
//    public void setIdentifyCode(String identifyCode) {
//        this.identifyCode = identifyCode;
//    }

    public String login() {
        try {

            UserDto user = loginService.login(loginID, password);
            if (user == null) {
                addActionError(getText("MSG_LOGIN_FAILED"));
                return INPUT;
            }           

            HttpServletResponse response = ServletActionContext.getResponse();
            HttpServletRequest request = ServletActionContext.getRequest();

            // Add the login ID into the cookie for SSO
            // Set the Login ID into the cookie
            Cookie cookieLoginID = new Cookie(PassportConstant.LOGIN_ID, user.getLoginID());
            cookieLoginID.setPath("/");
            // - value mean the cookie will be delete when browse closed.
            cookieLoginID.setMaxAge(-1);
            response.addCookie(cookieLoginID);

            // Set the User ID into the cookie
            Cookie cookieUserID = new Cookie(PassportConstant.USER_ID, user.getUserID().toString());
            cookieUserID.setPath("/");
            // - value mean the cookie will be delete when browse closed.
            cookieUserID.setMaxAge(-1);
            response.addCookie(cookieUserID);

            // Set the user name into the cookie
            String userName = user.getUserName();
            Cookie cookieUserName = new Cookie(PassportConstant.USER_NAME, URLEncoder.encode(userName, CoreConstants.ENCODING_UTF8));
            cookieUserName.setPath("/");
            cookieUserName.setMaxAge(-1);
            response.addCookie(cookieUserName);

            // Set the login user id into the session.
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            sessionMap.put(PassportConstant.LOGIN_USER, user);

            // Put the login user's role list into the session.
            List<RoleDto> roleList = loginService.getUserRoleList(user.getUserID());
            sessionMap.put(PassportConstant.LOGIN_ROLE_LIST, roleList);
            
            // Put the user's resource list into the session.
            List<ResourceDto> resourceList = loginService.getUserResourceList(roleList);
            sessionMap.put(PassportConstant.LOGIN_RESOURCE_LIST, resourceList);
            List<String> resourceURLList = new ArrayList<String>();
            for (ResourceDto resourceDto : resourceList) {
                resourceURLList.add(resourceDto.getResourceURL());
            }
            sessionMap.put(PassportConstant.LOGIN_RESOURCE_URL_LIST, resourceURLList);
            
            // Redirect to the URL of saved form Filter
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(PassportConstant.ACCESS_URL)) {
                        response.sendRedirect(cookie.getValue());
                        break;
                    }
                }
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateLogin() {
        try {
            // The login id and password is required.
            if (loginID == null || loginID.isEmpty()) {
                addActionError(this.getText("MSG_LOGIN_LOGIN_ID_REQUIRE"));
            }

            if (password == null || password.isEmpty()) {
                addActionError(this.getText("MSG_LOGIN_PASSWORD_REQUIRE"));
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
