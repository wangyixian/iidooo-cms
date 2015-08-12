package com.iidooo.cms.action;

import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.core.action.BaseAction;

public class CmsBaseAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private SiteDto defaultSite;

    public SiteDto getDefaultSite() {
        return defaultSite;
    }

    public void setDefaultSite(SiteDto defaultSite) {
        this.defaultSite = defaultSite;
    }

}
