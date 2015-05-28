package com.iidooo.passport.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.util.SecurityUtil;
import com.iidooo.passport.dao.extend.SecurityUserDao;
import com.iidooo.passport.dto.extend.SecurityUserDto;
import com.iidooo.passport.service.ILoginService;

@Service
public class LoginService implements ILoginService{
    
    private static final Logger logger = Logger.getLogger(LoginService.class);
    
    @Autowired
    private SecurityUserDao securityUserDao;
    
    @Override
    public SecurityUserDto login(String loginID, String password) {
        try {
            password = SecurityUtil.getMd5(password);
            SecurityUserDto result = securityUserDao.selectForLogin(loginID, password);          
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
