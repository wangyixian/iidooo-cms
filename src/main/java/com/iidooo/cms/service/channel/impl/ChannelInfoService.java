package com.iidooo.cms.service.channel.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelInfoService;

@Service
public class ChannelInfoService implements IChannelInfoService {
    
    private static final Logger logger = Logger.getLogger(ChannelInfoService.class);

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
            throw e;
        }
    }
    
}
