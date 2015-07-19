package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.Content;
import com.iidooo.core.util.DateUtil;

public class ContentDto extends Content {

    private Integer siteID;

    // This field for change the content's channel on the ContentDetail Page
    private Integer newChannelID;

    private String channelName;

    private String channelPath;

    private String createUserName;

    public Integer getSiteID() {
        return siteID;
    }

    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
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

    public String getChannelPath() {
        return channelPath;
    }

    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateDate() {
        String date = DateUtil.format(this.getUpdateTime(), DateUtil.FORMAT_DATETIME, DateUtil.FORMAT_DATE);
        return date;
    }
}
