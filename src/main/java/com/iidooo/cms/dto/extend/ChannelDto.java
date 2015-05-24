package com.iidooo.cms.dto.extend;

import java.util.ArrayList;
import java.util.List;

import com.iidooo.cms.dto.generate.Channel;

public class ChannelDto extends Channel {

    private String siteURL;

    private String createUserName;

    private String updateUserName;

    // The children channels of this channel
    private List<ChannelDto> children;

    public String getSiteURL() {
        return siteURL;
    }

    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public List<ChannelDto> getChildren() {
        if (children == null) {
            children = new ArrayList<ChannelDto>();
        }
        return children;
    }

    public void setChildren(List<ChannelDto> children) {
        this.children = children;
    }
}
