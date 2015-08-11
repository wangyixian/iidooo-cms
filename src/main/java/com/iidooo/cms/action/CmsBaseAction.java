package com.iidooo.cms.action;

import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.core.action.BaseAction;

public class CmsBaseAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private SiteDto site;

    public SiteDto getSite() {
        return site;
    }

    public void setSite(SiteDto site) {
        this.site = site;
    }

}
