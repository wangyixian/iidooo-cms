package com.iidooo.passport.action.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.user.UserDetailService;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.ValidateUtil;

public class UserDetailAction extends BaseAction  {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(UserDetailAction.class);

    @Autowired
    private UserDetailService userInfoService;

    private UserDto user;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String init() {
        try {
            // The modify mode will trace the user ID.
            if (user != null && user.getUserID() != null && user.getUserID() > 0) {
                user = userInfoService.getUserByID(user.getUserID());
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String create() {
        try {

            // The validate of channel path should not be duplicated.
            if (userInfoService.isLoginIDDuplicate(user.getLoginID())) {
                addActionError(getText("MSG_USER_CREATE_FAILED_DUPLICATE", new String[] {user.getLoginID() }));
                return INPUT;
            }

            if (!userInfoService.createUser(user)) {
                addActionError(getText("MSG_USER_CREATE_FAILED"));
                return INPUT;
            }
            addActionMessage(getText("MSG_USER_CREATE_SUCCESS", new String[] { user.getLoginID() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateCreate() {
        try {
            // The validate of user loginID should not be empty.
            if (ValidateUtil.isEmpty(user.getLoginID())) {
                addActionError(getText("MSG_USER_LOGINID_REQUIRE"));
            }

            // The validate of user name should not be empty.
            if (ValidateUtil.isEmpty(user.getUserName())) {
                addActionError(getText("MSG_USER_USERNAME_REQUIRE"));
            }

            // The validate of user password should not be empty.
            if (!ValidateUtil.isEmpty(user.getPassword())) {
                addActionError(getText("MSG_USER_PASSWORD_REQUIRE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }

    public String update() {
        try {
            if (!userInfoService.updateUser(user)) {
                addActionError(getText("MSG_USER_UPDATE_FAILED", new String[] { user.getLoginID()}));
                return INPUT;
            }
            addActionMessage(getText("MSG_USER_UPDATE_SUCCESS", new String[] { user.getLoginID()}));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateUpdate() {
        try {

            if (user == null ||ValidateUtil.isEmpty(user.getLoginID())) {
                addActionError(getText("MSG_USER_LOGINID_REQUIRE"));
            }
            // The validate of user name should not be empty.
            if (ValidateUtil.isEmpty(user.getUserName())) {
                addActionError(getText("MSG_USER_USERNAME_REQUIRE"));
            }

            // The validate of user password should not be empty.
            if (!ValidateUtil.isEmpty(user.getPassword())) {
                addActionError(getText("MSG_USER_PASSWORD_REQUIRE"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }
}
