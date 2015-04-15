package com.iidooo.cms.service.channel.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelListService;

@Service
public class ChannelListService implements IChannelListService {

    private static final Logger logger = Logger.getLogger(ChannelListService.class);

    @Autowired
    private ChannelDao channelDao;

    @Override
    public List<ChannelDto> searchChannelList(ChannelDto channel) {
        try {
            List<ChannelDto> channelList = null;
            channelList = channelDao.selectByParentID(parentID);
            return channelList;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

}
