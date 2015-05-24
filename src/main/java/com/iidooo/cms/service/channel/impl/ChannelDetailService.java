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
import com.opensymphony.xwork2.ActionContext;

@Service
public class ChannelDetailService implements IChannelDetailService {

    private static final Logger logger = Logger.getLogger(ChannelDetailService.class);

    @Autowired
    private ChannelDao channelDao;

    @Override
    public ChannelDto getChannelByID(int channelID) {
        try {
            ChannelDto result = channelDao.selectChannelByID(channelID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public ChannelDto getChannelByPath(String channelPath) {
        try {
            ChannelDto result = channelDao.selectChannelByPath(channelPath);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public boolean createChannel(ChannelDto channel) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            int userID = (int) sessionMap.get(PassportConstant.USER_ID);
            channel.setCreateUser(userID);
            channel.setCreateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            channel.setUpdateUser(userID);
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            // Set the channel level
            ChannelDto parentChannel = channelDao.selectChannelByID(channel.getParentID());
            if (parentChannel == null) {
                channel.setChannelLevel(1);
            } else {
                channel.setChannelLevel(parentChannel.getChannelLevel() + 1);
            }

            // Set the channel sequence
            int sequence = 1;
            List<ChannelDto> channelDtos = channelDao.selectByParentID(channel.getParentID());
            if (channelDtos != null) {
                for (ChannelDto cmsChannelDto : channelDtos) {
                    if (cmsChannelDto.getSequence() > sequence) {
                        sequence = cmsChannelDto.getSequence() + 1;
                    }
                }
            }
            channel.setSequence(sequence);
            
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
            int userID = (int) sessionMap.get(PassportConstant.USER_ID);
            channel.setUpdateUser(userID);
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            // Set the channel level
            ChannelDto parentChannel = channelDao.selectChannelByID(channel.getParentID());
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
