package com.iidooo.passport.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.SecurityUtil;
import com.iidooo.passport.dao.extend.UserDao;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.IPasswordService;

@Service
public class PasswordService implements IPasswordService {
    private static final Logger logger = Logger.getLogger(PasswordService.class);

    @Autowired
    private UserDao securityUserDao;
    
    @Override
    public boolean checkOldPassword(String loginID, String oldPassword) {
        try {
            oldPassword = SecurityUtil.getMd5(oldPassword);
            UserDto user = securityUserDao.selectForLogin(loginID, oldPassword);
            if (user == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean saveNewPassword(UserDto user, String newPassword) {
        try {
            user.setUpdateUser(user.getUserID());
            user.setPassword(SecurityUtil.getMd5(newPassword));
            user.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            securityUserDao.updatePassword(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }
}
