package com.iidooo.cms.client.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.client.service.ChannelService;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;

@Service
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
//
//            HashMap<Integer, CmsChannelDto> channelDtosMap = new HashMap<Integer, CmsChannelDto>();
//            for (CmsChannelDto cmsChannelDto : allChannelDtos) {
//                channelDtosMap.put(cmsChannelDto.getChannelID(), cmsChannelDto);
//            }
//
//            for (CmsChannelDto cmsChannelDto : allChannelDtos) {
//                int level = 1;
//                CmsChannelDto parentChannel = channelDtosMap.get(cmsChannelDto.getParentID());
//                while (parentChannel != null) {
//                    level++;
//                    parentChannel = channelDtosMap.get(parentChannel.getParentID());
//                }
//                cmsChannelDto.setLevel(level);
//            }
            return allChannelDtos;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    public CmsChannelDto getChannelByID(int channelID) {
        try {
            CmsChannelDto channelDto = null;
            channelDto = cmsChannelDao.selectChannelByID(channelID);
            return channelDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
}
