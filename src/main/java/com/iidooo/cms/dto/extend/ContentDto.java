package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.Content;

public class ContentDto extends Content {

    private String channelName;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
