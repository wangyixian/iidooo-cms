package com.iidooo.cms.action.index;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.index.SiteListService;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.RoleDto;
import com.opensymphony.xwork2.ActionContext;

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
