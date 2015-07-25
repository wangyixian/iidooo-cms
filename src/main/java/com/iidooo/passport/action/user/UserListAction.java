package com.iidooo.passport.action.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.PageUtil;
import com.iidooo.core.util.ValidateUtil;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.user.IUserListService;

public class UserListAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(UserListAction.class);

    @Autowired
    private IUserListService userListService;

    private List<UserDto> userList;

    private UserDto user;

    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String init() {
        try {
            int count = userListService.getUserListCount();

            PageUtil pageUtil = new PageUtil(this.getServletContext());
            PageDto page = pageUtil.executePage(count, this.getPage());
            this.setPage(page);

            this.userList = userListService.getUserList(this.getPage());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String delete() {
        try {
            if (!userListService.deleteUser(this.user)) {
                addActionError(getText("MSG_USER_DELETE_FAILED", new String[] { user.getUserName() }));
                return INPUT;
            }
            addActionMessage(getText("MSG_USER_DELETE_SUCCESS", new String[] { user.getUserName() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateDelete() {
        try {
            if (user == null || ValidateUtil.isEmpty(user.getUserID())) {
                addActionError(getText("MSG_USER_ID_REQUIRE"));
            }          
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
