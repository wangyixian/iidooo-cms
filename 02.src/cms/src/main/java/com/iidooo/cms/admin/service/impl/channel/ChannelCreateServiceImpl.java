package com.iidooo.cms.admin.service.impl.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.channel.ChannelCreateService;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;

@Service
public class ChannelCreateServiceImpl implements ChannelCreateService {
    private static final Logger logger = Logger.getLogger(ChannelCreateServiceImpl.class);

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
