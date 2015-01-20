package com.iidooo.framework.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.service.LoginService;
import com.iidooo.framework.utility.StringUtil;

public class LoginAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(LoginAction.class);

    @Autowired
    private LoginService authService;

    private SecurityUserDto securityUser;

    public SecurityUserDto getSecurityUser() {
        return securityUser;
    }

    public void setSecurityUser(SecurityUserDto securityUser) {
        this.securityUser = securityUser;
    }

    public String init() {
        try {
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String login() {
        try {
            this.setSession(SessionConstant.SECURITY_USER, securityUser);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateLogin() {
        try {
            String loginID = securityUser.getLoginID();
            String password = securityUser.getPassword();
            if (StringUtil.isEmpty(loginID)) {
                addFieldError("authService.loginID", this.getText("MSG_COMMON_REQUIRED", new String[] { getText("LABEL_LOGIN_ID") }));
            }
            if (StringUtil.isEmpty(password)) {
                addFieldError("authService.password", this.getText("MSG_COMMON_REQUIRED", new String[] { getText("LABEL_LOGIN_ID") }));
            }
            securityUser = authService.auth(loginID, password);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
