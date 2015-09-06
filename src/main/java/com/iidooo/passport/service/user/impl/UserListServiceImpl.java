package com.iidooo.passport.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dao.extend.UserDao;
import com.iidooo.passport.dto.extend.UserDto;
import com.iidooo.passport.service.user.UserListService;
import com.opensymphony.xwork2.ActionContext;
@Service
public class UserListServiceImpl implements UserListService {

    private static final Logger logger = Logger.getLogger(UserListServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getUser(int userID) {
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
    public int getUserListCount() {
        int result = 0;
        try {
            result = userDao.selectAllCount();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public List<UserDto> getUserList(PageDto page) {
        List<UserDto> result = new ArrayList<UserDto>();
        try {
            result = userDao.selectAll(page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public boolean deleteUser(UserDto user) {
        try {

            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto loginUser = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            user.setUpdateUser(loginUser.getUserID());
            user.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            int count = userDao.delete(user);
            if (count <= 0) {
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
