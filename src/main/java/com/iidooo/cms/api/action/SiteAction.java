package com.iidooo.cms.api.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.ISiteService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.core.action.common.BaseAPIAction;
import com.iidooo.core.constant.HttpConstant;
import com.iidooo.core.util.JsonUtil;

public class SiteAction extends BaseAPIAction{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(SiteAction.class);
    
    @Autowired
    private ISiteService siteService;

    public void site() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case HttpConstant.METHOD_GET:
                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);

                if (siteCode == null || siteCode.isEmpty()) {
                    return;
                }

                SiteDto site = siteService.getSite(siteCode);
                JsonUtil.responseObject(site, this.getResponse());
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
