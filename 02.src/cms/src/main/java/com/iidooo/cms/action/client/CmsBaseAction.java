package com.iidooo.cms.action.client;

import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.freemarker.directive.ContentList;
import com.iidooo.framework.action.BaseAction;

public abstract class CmsBaseAction extends BaseAction{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ContentList contentList;

    public ContentList getContentList() {
        return contentList;
    }
    
    
}
