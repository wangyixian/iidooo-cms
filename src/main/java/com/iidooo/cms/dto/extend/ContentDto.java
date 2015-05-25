package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.Content;
import com.iidooo.core.util.DateUtil;

public class ContentDto extends Content {

    private Integer channelID;
    
    // This field for change the content's channel on the ContentDetail Page
    private Integer newChannelID;

    private String channelName;

    public Integer getChannelID() {
        return channelID;
    }

    public void setChannelID(Integer channelID) {
        this.channelID = channelID;
    }

    public Integer getNewChannelID() {
        return newChannelID;
    }

    public void setNewChannelID(Integer newChannelID) {
        this.newChannelID = newChannelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    
    public String getUpdateDate(){
        String date =  DateUtil.format(this.getUpdateTime(), DateUtil.FORMAT_DATETIME, DateUtil.FORMAT_DATE);
        return date;
    }
}
