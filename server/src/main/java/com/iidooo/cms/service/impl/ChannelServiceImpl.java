package com.iidooo.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.mapper.CmsChannelMapper;
import com.iidooo.cms.model.po.CmsChannel;
import com.iidooo.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService{
    
    private static final Logger logger = Logger.getLogger(ChannelServiceImpl.class);
    
    @Autowired
    private CmsChannelMapper cmsChannelMapper;
    
    @Override
    public List<CmsChannel> getAllChannelList() {
        try {
            List<CmsChannel> result = cmsChannelMapper.selectChannelList();
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

}
