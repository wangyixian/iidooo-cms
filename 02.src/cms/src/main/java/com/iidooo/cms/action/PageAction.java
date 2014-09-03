package com.iidooo.cms.action;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.CmsBlockDto;
import com.iidooo.cms.dto.generate.CmsPage;
import com.iidooo.cms.service.PageService;
import com.iidooo.framework.action.BaseAction;

public class PageAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(PageAction.class);

    private CmsPage cmsPage;
    
    private HashMap<String, CmsBlockDto> blockMap;
    
    public CmsPage getCmsPage() {
        return cmsPage;
    }

    public void setCmsPage(CmsPage cmsPage) {
        this.cmsPage = cmsPage;
    }

    public HashMap<String, CmsBlockDto> getBlockMap() {
        return blockMap;
    }

    public void setBlockMap(HashMap<String, CmsBlockDto> blockMap) {
        this.blockMap = blockMap;
    }

    @Autowired
    private PageService pageService;

    @Override
    public String execute() throws Exception {
        try {
            String pageName = getRequest().getParameter("pageName");
            if (pageName != null) {
                cmsPage = pageService.getPageByName(pageName);
                if (cmsPage != null) {
                    blockMap = pageService.getBlockMap(cmsPage.getPageID());
                }
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return super.execute();
    }

}
