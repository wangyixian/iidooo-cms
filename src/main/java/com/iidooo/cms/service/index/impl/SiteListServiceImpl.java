package com.iidooo.cms.service.index.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dao.extend.SiteDao;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.index.SiteListService;
import com.iidooo.passport.dto.extend.RoleDto;

@Service
public class SiteListServiceImpl implements SiteListService {

    private static final Logger logger = Logger.getLogger(SiteListServiceImpl.class);

    @Autowired
    private SiteDao siteDao;
    
    @Autowired
    private ChannelDao channelDao;
    
    @Autowired
    private ContentDao contentDao;

    @Override
    public List<SiteDto> getSiteList(List<RoleDto> roleList) {
        List<SiteDto> result = new ArrayList<SiteDto>();
        try {
            result = siteDao.selectSiteListByRoles(roleList);

            for (SiteDto item : result) {
                int channelSum = channelDao.selectCountBySiteID(item.getSiteID());
                int contentSum = contentDao.selectCountBySiteID(item.getSiteID());
                
                item.setChannelSum(channelSum);
                item.setContentSum(contentSum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

}
