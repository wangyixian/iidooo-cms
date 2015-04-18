package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.Content;

public class ContentDto extends Content {

    private Integer channelID;

    private String channelName;

    public Integer getChannelID() {
        return channelID;
    }

    public void setChannelID(Integer channelID) {
        this.channelID = channelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
