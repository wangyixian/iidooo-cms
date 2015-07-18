package com.iidooo.cms.service.channel.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelDetailService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.UserDto;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ChannelDetailService implements IChannelDetailService {

    private static final Logger logger = Logger.getLogger(ChannelDetailService.class);

    @Autowired
    private ChannelDao channelDao;

    @Override
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

    @Override
    public boolean isChannelPathDuplicate(int siteID, String channelPath) {
        try {
            ChannelDto channel = new ChannelDto();
            channel.setSiteID(siteID);
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
            UserDto user = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            channel.setCreateUser(user.getUserID());
            channel.setCreateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            channel.setUpdateUser(user.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            // Set the channel level
            ChannelDto parentChannel = channelDao.selectByChannelID(channel.getParentID());
            if (parentChannel == null) {
                channel.setChannelLevel(1);
            } else {
                channel.setChannelLevel(parentChannel.getChannelLevel() + 1);
            }

            // Set the channel sequence
            int maxSequence = channelDao.selectMaxSequence(channel.getParentID());
            channel.setSequence(maxSequence + 1);

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
            UserDto user = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            channel.setUpdateUser(user.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

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
