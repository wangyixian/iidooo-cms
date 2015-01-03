package com.iidooo.cms.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.ChannelDetailService;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;

@Service
public class ChannelDetailServiceImpl implements ChannelDetailService {
    private static final Logger logger = Logger.getLogger(ChannelDetailServiceImpl.class);

    @Autowired
    private CmsChannelDao cmsChannelDao;

    @Override
    public void createChannel(CmsChannelDto channel) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
