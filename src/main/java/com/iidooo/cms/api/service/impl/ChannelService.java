package com.iidooo.cms.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.api.service.IChannelService;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;

@Service
public class ChannelService implements IChannelService{
    
    private static final Logger logger = Logger.getLogger(ChannelService.class);

    @Autowired
    private ChannelDao channelDao;
    
    @Override
    public List<ChannelDto> getChannelList(String siteCode, int channelLevel) {
        List<ChannelDto> result = new ArrayList<ChannelDto>();
        try {
            result = channelDao.selectChannelsBySite(siteCode, channelLevel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }
    
    @Override
    public List<ChannelDto> getDisplayChannelList(String siteCode, int channelLevel){
        List<ChannelDto> result = new ArrayList<ChannelDto>();
        try {
            result = channelDao.selectChannelsBySite(siteCode, channelLevel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public ChannelDto getChannel(String siteCode, String channelPath) {
        try {
            ChannelDto result = null; 
            result = channelDao.selectChannelByPath(siteCode, channelPath);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
    
    
}
