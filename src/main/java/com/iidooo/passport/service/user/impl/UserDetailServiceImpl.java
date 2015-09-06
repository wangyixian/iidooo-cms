package com.iidooo.passport.service.user.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dao.extend.UserDao;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.user.UserDetailService;
import com.opensymphony.xwork2.ActionContext;
@Service
public class UserDetailServiceImpl implements UserDetailService {

    private static final Logger logger = Logger.getLogger(UserDetailServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getUserByID(int userID) {
        try {
            UserDto result = userDao.selectByPrimaryKey(userID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public boolean isLoginIDDuplicate( String loginID) {
        try {

            UserDto user = userDao.selectByLoginID(loginID);
            if (user == null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean createUser(UserDto user) {
        try {

            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto loginUser = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            user.setCreateUser(loginUser.getUserID());
            user.setCreateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            user.setUpdateUser(loginUser.getUserID());
            user.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            int result = userDao.insert(user);
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

    @Override
    public boolean updateUser(UserDto user) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto loginUser = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            user.setUpdateUser(loginUser.getUserID());
            user.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            int result = userDao.update(user);
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
