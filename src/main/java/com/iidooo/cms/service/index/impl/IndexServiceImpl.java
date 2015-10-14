package com.iidooo.cms.service.index.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.SiteDao;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.index.IndexService;
import com.iidooo.core.dto.extend.SecurityRoleDto;

@Service
public class IndexServiceImpl implements IndexService {

    private static final Logger logger = Logger.getLogger(IndexServiceImpl.class);

    @Autowired
    private SiteDao siteDao;

    @Override
    public List<SiteDto> getSiteList(List<SecurityRoleDto> roleList) {
        List<SiteDto> result = new ArrayList<SiteDto>();
        try {
            result = siteDao.selectSiteListByRoles(roleList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }
}
