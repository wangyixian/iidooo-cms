package com.iidooo.cms.service.index.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.action.index.IndexAction;
import com.iidooo.cms.dao.extend.SiteDao;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.index.IndexService;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.RoleDto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Service
public class IndexServiceImpl implements IndexService {

    private static final Logger logger = Logger.getLogger(IndexServiceImpl.class);

    @Autowired
    private SiteDao siteDao;

    @Override
    public List<SiteDto> getSiteList(List<RoleDto> roleList) {
        List<SiteDto> result = new ArrayList<SiteDto>();
        try {
            result = siteDao.selectSiteList(roleList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

}
