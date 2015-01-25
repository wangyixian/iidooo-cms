package com.iidooo.cms.admin.action.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.action.channel.ChannelListAction;
import com.iidooo.cms.admin.service.channel.ChannelListService;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.action.BaseAction;

public class ContentDetailAction extends BaseAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(ChannelListAction.class);
    


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
