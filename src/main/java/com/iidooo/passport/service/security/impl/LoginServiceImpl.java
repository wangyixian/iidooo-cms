package com.iidooo.passport.service.security.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.SecurityUtil;
import com.iidooo.passport.dao.extend.ResourceDao;
import com.iidooo.passport.dao.extend.RoleDao;
import com.iidooo.passport.dao.extend.UserDao;
import com.iidooo.passport.dto.extend.ResourceDto;
import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.security.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public UserDto login(String loginID, String password) {
        try {
            password = SecurityUtil.getMd5(password);
            UserDto result = userDao.selectForLogin(loginID, password);

            if (result != null) {
                result.setLoginTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
                userDao.updateLoginTime(result);
            }

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
            result = roleDao.selectSecurityRoleList(securityUser);
        } catch (Exception e) {
            logger.fatal(e);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ResourceDto> getUserResourceList(List<RoleDto> roles) {
        List<ResourceDto> result = new ArrayList<ResourceDto>();
        try {
            if (roles != null && roles.size() > 0) {
                result = resourceDao.selectResourceListByRoles(roles);
            }
        } catch (Exception e) {
            logger.fatal(e);
            e.printStackTrace();
        }
        return result;
    }

}
