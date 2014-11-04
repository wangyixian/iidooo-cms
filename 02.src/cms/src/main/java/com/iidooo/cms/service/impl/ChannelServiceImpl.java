package com.iidooo.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.service.ChannelService;

@Repository
public class ChannelServiceImpl implements ChannelService {

    private static final Logger logger = Logger.getLogger(ChannelServiceImpl.class);

    @Autowired
    private CmsChannelDao cmsChannelDao;

    public CmsChannelDto getChannelByPath(String channelPath) {
        try {
            CmsChannelDto channelDto = null;
            channelDto = cmsChannelDao.selectChannelByPath(channelPath);
            return channelDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    public List<CmsChannelDto> getAllChannels() {
        try {
            List<CmsChannelDto> allChannelDtos = cmsChannelDao.selectAllChannels();

            HashMap<Integer, CmsChannelDto> channelDtosMap = new HashMap<Integer, CmsChannelDto>();
            for (CmsChannelDto cmsChannelDto : allChannelDtos) {
                channelDtosMap.put(cmsChannelDto.getChannelID(), cmsChannelDto);
            }

            for (CmsChannelDto cmsChannelDto : allChannelDtos) {
                int level = 1;
                CmsChannelDto parentChannel = channelDtosMap.get(cmsChannelDto.getParentChannelID());
                while (parentChannel != null) {
                    level++;
                    parentChannel = channelDtosMap.get(parentChannel.getParentChannelID());
                }
                cmsChannelDto.setLevel(level);
            }
            return allChannelDtos;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
}
