package com.iidooo.cms.action.index;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.service.index.SiteListService;

public class SiteListAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(SiteListAction.class);

    @Autowired
    private SiteListService siteListService;


    public String init() {
        try {


            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
