package com.iidooo.passport.service.impl;

import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dao.extend.UserDao;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.IUserinfoService;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

@Service
public class UserinfoService implements IUserinfoService {

    private static final Logger logger = Logger.getLogger(UserinfoService.class);

    @Autowired
    private UserDao securityUserDao;

    @Override
    public UserDto getUser(String loginID) {
        try {
            UserDto result = securityUserDao.selectByLoginID(loginID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public boolean saveUser(UserDto user) {
        try {
            // Set SecurityUser key of loginID and userID from the session SecurityUser.
            // Because this way is safety.
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto sessionUser = (UserDto) sessionMap.get(PassportConstant.SECURITY_USER);
            user.setLoginID(sessionUser.getLoginID());
            user.setUserID(sessionUser.getUserID());

            user.setUpdateUser(user.getUserID());
            user.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            int result = securityUserDao.updateByPrimaryKey(user);
            if (result <= 0) {
                return false;
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }
}
