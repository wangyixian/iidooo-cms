package com.iidooo.cms.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.iidooo.cms.service.system.LoginService;
import com.iidooo.core.dao.extend.SecurityResDao;
import com.iidooo.core.dao.extend.SecurityRoleDao;
import com.iidooo.core.dao.extend.SecurityUserDao;
import com.iidooo.core.dto.extend.SecurityResDto;
import com.iidooo.core.dto.extend.SecurityRoleDto;
import com.iidooo.core.dto.extend.SecurityUserDto;
import com.iidooo.core.util.MybatisUtil;
import com.iidooo.core.util.SecurityUtil;

public class LoginServiceImpl implements LoginService {

    private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Override
    public SecurityUserDto login(String loginID, String password) {
        SecurityUserDto result = null;
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            // 密码是通过MD5算法加密的
            password = SecurityUtil.getMd5(password);
            SecurityUserDao userDao = sqlSession.getMapper(SecurityUserDao.class);
            result = userDao.selectForLogin(loginID, password);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    @Override
    public List<SecurityRoleDto> getUserRoleList(int userID) {
        List<SecurityRoleDto> result = new ArrayList<SecurityRoleDto>();
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            SecurityRoleDao roleDao = sqlSession.getMapper(SecurityRoleDao.class);
            result = roleDao.selectByUserID(userID);
        } catch (Exception e) {
            logger.fatal(e);
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return result;
    }

    @Override
    public List<SecurityResDto> getUserResourceList(List<SecurityRoleDto> roles) {
        List<SecurityResDto> result = new ArrayList<SecurityResDto>();
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {

            SecurityResDao resourceDao = sqlSession.getMapper(SecurityResDao.class);
            if (roles != null && roles.size() > 0) {
                result = resourceDao.selectResourceListByRoles(roles);
            }
        } catch (Exception e) {
            logger.fatal(e);
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }
}
