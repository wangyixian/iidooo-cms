package com.iidooo.cms.action;

import org.apache.log4j.Logger;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.action.BaseAction;

public abstract class FrontBaseAction extends BaseAction{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(FrontBaseAction.class);
    
    private ChannelDto channel;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }
    
    
}
