package com.iidooo.cms.service.channel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.ChannelListService;
import com.iidooo.cms.util.ChannelUtil;
import com.iidooo.core.constant.DateTimeFormat;
import com.iidooo.core.constant.SessionConstant;
import com.iidooo.core.dto.extend.SecurityUserDto;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.MybatisUtil;
import com.opensymphony.xwork2.ActionContext;

public class ChannelListServiceImpl implements ChannelListService {

    private static final Logger logger = Logger.getLogger(ChannelListServiceImpl.class);

    @Override
    public ChannelDto getChannel(int channelID) {
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
    public List<ChannelDto> getChildrenChannelList(int parentID) {
        List<ChannelDto> result = new ArrayList<ChannelDto>();
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        try {

            ChannelDao channelDao = sqlSession.getMapper(ChannelDao.class);

            result = channelDao.selectByParentID(parentID);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        } finally {
            sqlSession.close();
        }
        return result;
    }

}
