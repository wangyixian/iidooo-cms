package com.iidooo.passport.api.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.passport.api.service.ISecurityUserService;
import com.iidooo.passport.dao.extend.SecurityUserDao;
import com.iidooo.passport.dto.extend.SecurityUserDto;

@Service
public class SecurityUserService implements ISecurityUserService {

    private static final Logger logger = Logger.getLogger(SecurityUserService.class);
    
    @Autowired
    private SecurityUserDao securityUserDao;
    
    @Override
    public SecurityUserDto getSecurityUser(Integer userID) {
        try {
            return securityUserDao.selectByPrimaryKey(userID);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
