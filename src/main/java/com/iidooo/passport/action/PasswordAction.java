package com.iidooo.passport.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.SecurityUserDto;
import com.iidooo.passport.service.IPasswordService;
import com.opensymphony.xwork2.ActionContext;

public class PasswordAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(PasswordAction.class);

    @Autowired
    private IPasswordService passwordService;

    private String oldPassword;

    private String newPassword;

    private String newPasswordRepeat;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRepeat() {
        return newPasswordRepeat;
    }

    public void setNewPasswordRepeat(String newPasswordRepeat) {
        this.newPasswordRepeat = newPasswordRepeat;
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

    public String save() {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto sessionUser = (SecurityUserDto) sessionMap.get(PassportConstant.SECURITY_USER);
            if (!passwordService.checkOldPassword(sessionUser.getLoginID(), oldPassword)) {
                addActionError(this.getText("MSG_PASSWORD_FAILED"));  
                return INPUT;
            }
            if (passwordService.saveNewPassword(sessionUser, newPassword)) {
                addActionMessage(getText("MSG_SAVE_SUCCESS", new String[] { getText("LABEL_PASSWORD_NEW") }));
            } else {
                addActionError(getText("MSG_SAVE_FAILED", new String[] { getText("LABEL_PASSWORD_NEW") }));
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateSave(){
        try {
            if (oldPassword == null || oldPassword.isEmpty()) {
                addActionError(this.getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_PASSWORD_OLD") }));
            }
            if (newPassword == null || newPassword.isEmpty()) {
                addActionError(this.getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_PASSWORD_NEW") }));
            }
            if (newPasswordRepeat == null || newPasswordRepeat.isEmpty()) {
                addActionError(this.getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_PASSWORD_NEW_REPEAT") }));
            }
            if (newPassword != null && !newPassword.isEmpty() && newPasswordRepeat != null && !newPasswordRepeat.isEmpty()) {
                if (!newPassword.equals(newPasswordRepeat)) {
                    addActionError(this.getText("MSG_PASSWORD_REPEAT_FAILED"));                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
