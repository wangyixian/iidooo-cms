package com.iidooo.cms.dto.extend;

import java.util.ArrayList;
import java.util.List;

import com.iidooo.cms.dto.generate.Channel;

public class ChannelDto extends Channel {

    private String userName;
    
    // The children channels of this channel
    private List<ChannelDto> children;

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
