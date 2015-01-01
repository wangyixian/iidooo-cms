package com.iidooo.cms.admin.action;

import org.apache.log4j.Logger;

import com.iidooo.framework.action.BaseAction;

public class IndexAction extends BaseAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(IndexAction.class);
    
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
