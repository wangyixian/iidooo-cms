package com.iidooo.passport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.util.SecurityUtil;
import com.iidooo.passport.dao.extend.RoleDao;
import com.iidooo.passport.dao.extend.UserDao;
import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.ILoginService;

@Service
public class LoginService implements ILoginService{
    
    private static final Logger logger = Logger.getLogger(LoginService.class);
    
    @Autowired
    private UserDao securityUserDao;
    
    @Autowired
    private RoleDao securityRoleDao;
    
    @Override
    public UserDto login(String loginID, String password) {
        try {
            password = SecurityUtil.getMd5(password);
            UserDto result = securityUserDao.selectForLogin(loginID, password);          
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public List<RoleDto> getUserRoleList(int userID) {
        List<RoleDto> result = new ArrayList<RoleDto>();
        try {
            UserDto securityUser = new UserDto();
            securityUser.setUserID(userID);
            result = securityRoleDao.selectSecurityRoleList(securityUser);
        } catch (Exception e) {
            logger.fatal(e);
            e.printStackTrace();
        }
        
        return result;
    }

}
