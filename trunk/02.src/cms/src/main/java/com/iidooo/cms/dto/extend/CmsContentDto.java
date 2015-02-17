package com.iidooo.cms.dto.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsContent;

public class CmsContentDto extends CmsContent {

    private String channelName;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
