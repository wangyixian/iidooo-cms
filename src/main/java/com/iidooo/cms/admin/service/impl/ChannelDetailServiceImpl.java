package com.iidooo.cms.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.ChannelDetailService;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.CmsTemplateDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;
import com.iidooo.framework.exception.ExclusiveException;

@Service
public class ChannelDetailServiceImpl implements ChannelDetailService {
    private static final Logger logger = Logger.getLogger(ChannelDetailServiceImpl.class);

    @Autowired
    private ChannelDao cmsChannelDao;

    @Override
    public boolean createChannel(ChannelDto channel) {
        try {
            channel.setCommonData(true);
            setChannelLevel(channel);
            setChannelSequence(channel);
            cmsChannelDao.insert(channel);
            channel.setChannelID(channel.getChannelID());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public ChannelDto getCurrentChannel(int channelID) {
        try {
            ChannelDto cmsChannelDto = cmsChannelDao.selectChannelByID(channelID);
            return cmsChannelDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }


    @Override
    public ChannelDto getChannelByPath(String channelPath) {
        try {
            ChannelDto cmsChannelDto = cmsChannelDao.selectChannelByPath(channelPath);
            return cmsChannelDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean updateChannel(ChannelDto channel) throws Exception {
        try {
            channel.setCommonData(false);
            setChannelLevel(channel);
            setChannelSequence(channel);
            cmsChannelDao.update(channel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean deleteChannel(ChannelDto channel) throws Exception {
        try {
            channel.setCommonData(false);
            cmsChannelDao.deleteByPrimaryKey(channel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    private void setChannelLevel(ChannelDto channel) {
        try {
            ChannelDto parentChannel = cmsChannelDao.selectChannelByID(channel.getParentID());
            if (parentChannel == null) {
                channel.setChannelLevel(1);
            } else {
                channel.setChannelLevel(parentChannel.getChannelLevel() + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    private void setChannelSequence(ChannelDto channel) {
        try {
            int sequence = 1;
            List<ChannelDto> channelDtos = cmsChannelDao.selectByParentID(channel.getParentID());
            if (channelDtos != null) {
                for (ChannelDto cmsChannelDto : channelDtos) {
                    if (cmsChannelDto.getSequence() > sequence) {
                        sequence = cmsChannelDto.getSequence() + 1;
                    }
                }
            }
            channel.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
