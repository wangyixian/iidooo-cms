package com.iidooo.cms.action.index;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.index.IndexService;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.RoleDto;
import com.opensymphony.xwork2.ActionContext;

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

            Map<String, Object> session = ActionContext.getContext().getSession();

            @SuppressWarnings("unchecked")
            List<RoleDto> roleList = (List<RoleDto>) session.get(PassportConstant.LOGIN_ROLE_LIST);

            // Set the site list into session
            List<SiteDto> siteList = indexService.getSiteList(roleList);
            session.put(CmsConstant.LOGIN_SITE_LIST, siteList);
            if (siteList.size() > 0) {
                this.setSite(siteList.get(0));
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
