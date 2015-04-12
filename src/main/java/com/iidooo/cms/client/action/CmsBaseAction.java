package com.iidooo.cms.client.action;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.action.BaseAction;

public abstract class CmsBaseAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private CmsChannelDto channel;

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    
    
}
