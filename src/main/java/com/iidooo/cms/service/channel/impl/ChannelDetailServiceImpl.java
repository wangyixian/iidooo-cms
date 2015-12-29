package com.iidooo.cms.service.channel.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.ChannelDetailService;
import com.iidooo.core.constant.DateTimeFormat;
import com.iidooo.core.constant.SessionConstant;
import com.iidooo.core.dto.extend.SecurityUserDto;
import com.iidooo.core.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;

public class ChannelDetailServiceImpl implements ChannelDetailService {

    private static final Logger logger = Logger.getLogger(ChannelDetailServiceImpl.class);

    private ChannelDao channelDao;

    public ChannelDto getChannelByID(int channelID) {
        try {
            ChannelDto result = channelDao.selectByChannelID(channelID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    public boolean isChannelPathDuplicate(String channelPath) {
        try {
            ChannelDto channel = new ChannelDto();
            channel.setChannelPath(channelPath);
            List<ChannelDto> channelList = channelDao.selectChannelList(channel);
            if (channelList.size() > 0) {
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
    public boolean createChannel(ChannelDto channel) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto user = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            channel.setCreateUser(user.getUserID());
            channel.setCreateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));
            channel.setUpdateUser(user.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));

            // Set the channel level
            ChannelDto parentChannel = channelDao.selectByChannelID(channel.getParentID());
            if (parentChannel == null) {
                channel.setChannelLevel(1);
            } else {
                channel.setChannelLevel(parentChannel.getChannelLevel() + 1);
            }

            // Set the channel sequence
            //int maxSequence = channelDao.selectMaxSequence(channel.getParentID());
            channel.setSequence(1);

            int result = channelDao.insert(channel);
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
    public boolean updateChannel(ChannelDto channel) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto user = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            channel.setUpdateUser(user.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));

            // Set the channel level
            ChannelDto parentChannel = channelDao.selectByChannelID(channel.getParentID());
            if (parentChannel == null) {
                channel.setChannelLevel(1);
            } else {
                channel.setChannelLevel(parentChannel.getChannelLevel() + 1);
            }

            int result = channelDao.update(channel);
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
