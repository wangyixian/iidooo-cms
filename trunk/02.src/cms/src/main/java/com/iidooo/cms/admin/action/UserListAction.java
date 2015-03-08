package com.iidooo.cms.admin.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.framework.action.BaseAction;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.service.SecurityUserService;

public class UserListAction extends PagingActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(UserListAction.class);

    @Autowired
    private SecurityUserService securityUserService;
    
    private List<SecurityUserDto> users;

    public List<SecurityUserDto> getUsers() {
        return users;
    }

    public void setUsers(List<SecurityUserDto> users) {
        this.users = users;
    }

    public String init() {
        try {
            int recordSum = securityUserService.getAllUsersCount();
            this.executePaging(recordSum);
            users = securityUserService.getAllUsers(this.getPagingDto());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
