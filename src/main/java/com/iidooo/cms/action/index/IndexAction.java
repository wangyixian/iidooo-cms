package com.iidooo.cms.action.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.index.IndexService;
import com.iidooo.core.constant.SessionConstant;
import com.iidooo.core.dto.extend.SecurityRoleDto;
import com.iidooo.core.util.JsonUtil;
import com.iidooo.core.util.ValidateUtil;

public class IndexAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(IndexAction.class);

    @Autowired
    private IndexService indexService;

    public String init() {
        try {
            @SuppressWarnings("unchecked")
            List<SecurityRoleDto> roleList = (List<SecurityRoleDto>) this.getSessionValue(SessionConstant.LOGIN_ROLE_LIST);

            // Set the site list into session
            List<SiteDto> siteList = indexService.getSiteList(roleList);
            this.setSessionValue(CmsConstant.SESSION_SITE_LIST, siteList);
            
            // Key: SiteID
            // Value: SiteDto
            Map<Integer, SiteDto> siteMap = new HashMap<Integer, SiteDto>();
            for (SiteDto item : siteList) {
                siteMap.put(item.getSiteID(), item);
            }
            this.setSessionValue(CmsConstant.SESSION_SITE_MAP, siteMap);
            
            // When the SESSION_DEFAULT_SITE is null, set the first site into the SESSION_DEFAULT_SITE.
            if (siteList.size() > 0) {                
                SiteDto defaultSite = (SiteDto)this.getSessionValue(CmsConstant.SESSION_DEFAULT_SITE);
                if (defaultSite == null) {
                    this.setSessionValue(CmsConstant.SESSION_DEFAULT_SITE, siteList.get(0));                    
                }
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void updateDefaultSite() {
        try {
            String defaultSiteID = getRequestParameter("defaultSiteID");
            if (ValidateUtil.isEmpty(defaultSiteID)) {
                return;
            }
            
            @SuppressWarnings("unchecked")
            Map<Integer, SiteDto> siteMap = (Map<Integer, SiteDto>)this.getSessionValue(CmsConstant.SESSION_SITE_MAP);
            SiteDto defaultSite = siteMap.get(Integer.parseInt(defaultSiteID));
            this.setSessionValue(CmsConstant.SESSION_DEFAULT_SITE, defaultSite);
            
            JsonUtil.responseObject(defaultSite, this.getResponse());
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
