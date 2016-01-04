package com.iidooo.cms.service.channel.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.ChannelDetailService;
import com.iidooo.core.constant.DateTimeFormat;
import com.iidooo.core.constant.SessionConstant;
import com.iidooo.core.dto.extend.SecurityUserDto;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.MybatisUtil;
import com.opensymphony.xwork2.ActionContext;

public class ChannelDetailServiceImpl implements ChannelDetailService {

    private static final Logger logger = Logger.getLogger(ChannelDetailServiceImpl.class);

    @Override
    public ChannelDto getChannelByID(int channelID) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);
            ChannelDto result = channelDao.selectByChannelID(channelID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public ChannelDto getChannelByPath(String channelPath) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);
            ChannelDto result = channelDao.selectByChannelPath(channelPath);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean createChannel(ChannelDto channel) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession(true);
        try {
            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto user = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            channel.setCreateUser(user.getUserID());
            channel.setCreateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));
            channel.setUpdateUser(user.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));

            // 设置序列
            Integer maxSequence = channelDao.selectMaxSequence(channel.getParentID());
            if (maxSequence == null) {
                channel.setSequence(1);
            } else {
                channel.setSequence(maxSequence+1);
            }
            
            int result = channelDao.insert(channel);
            if (result <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateChannel(ChannelDto channel) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession(true);
        try {
            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto user = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            channel.setUpdateUser(user.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));

            int result = channelDao.update(channel);
            if (result <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        } finally {
            sqlSession.close();
        }
    }


    @Override
    public boolean deleteChannel(ChannelDto channel) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession(true);
        try {
            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto use = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            channel.setUpdateUser(use.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));
            int count = channelDao.deleteByChannelID(channel);
            if (count <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        } finally {
            sqlSession.close();
        }
    }
    

    @Override
    public boolean hasChildren(int parentID) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);
            int count = channelDao.selectCountByParentID(parentID);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        } finally {
            sqlSession.close();
        }
    }
}
