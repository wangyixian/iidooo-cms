package com.iidooo.passport.action.user;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.ValidateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.ResourceDto;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.user.UserinfoService;
import com.opensymphony.xwork2.ActionContext;

public class UserinfoAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(UserinfoAction.class);

    @Autowired
    private UserinfoService userInfoService;

    private UserDto user;

    private ResourceDto resource;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ResourceDto getResource() {
        return resource;
    }

    public void setResource(ResourceDto resource) {
        this.resource = resource;
    }

    public String init() {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto sessionUser = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            user = userInfoService.getUser(sessionUser.getLoginID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String save() {
        try {
            if (userInfoService.saveUser(user)) {
                addActionMessage(getText("MSG_SAVE_SUCCESS", new String[] { getText("LABEL_USERINFO_BASIC") }));
                user = userInfoService.getUser(user.getLoginID());
            } else {
                addActionError(getText("MSG_SAVE_FAILED", new String[] { getText("LABEL_USERINFO_BASIC") }));
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateSave() {
        try {
            String birthday = user.getBirthday();
            if (!ValidateUtil.validateDateFormat(birthday, DateUtil.FORMAT_DATE)) {
                addActionError(this.getText("MSG_FIELD_FORMAT_ERROR", new String[] { getText("LABEL_USERINFO_BIRTHDAY") }));
            }

            String email = user.getEmail();
            if (!ValidateUtil.validateEmail(email)) {
                addActionError(this.getText("MSG_FIELD_FORMAT_ERROR", new String[] { getText("LABEL_USERINFO_EMAIL") }));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

}
