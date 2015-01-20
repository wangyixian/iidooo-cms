package com.iidooo.framework.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.SecurityUserDao;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.service.LoginService;
import com.iidooo.framework.utility.SecurityUtil;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private SecurityUserDao SecurityUserDao;

    @Override
    public SecurityUserDto auth(String loginID, String password) {
        try {
            SecurityUserDto securityUser = SecurityUserDao.selectByLoginID(loginID);
            
            // The user is not existed.
            if (securityUser == null) {
                return null;
            }
            
            // validate the password
            String md5Password = SecurityUtil.getMd5(password);
            if (!securityUser.getPassword().equals(md5Password)) {
                return null;
            }
            
            return securityUser;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

}
