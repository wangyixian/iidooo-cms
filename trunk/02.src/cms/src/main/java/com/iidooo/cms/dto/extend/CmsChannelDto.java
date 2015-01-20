package com.iidooo.cms.dto.extend;

import java.util.ArrayList;
import java.util.List;

import com.iidooo.cms.dto.generate.CmsChannel;

public class CmsChannelDto extends CmsChannel {
    private String templatePath;
    
    private List<CmsChannelDto> children;

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public List<CmsChannelDto> getChildren() {
        if (children == null) {
            children = new ArrayList<CmsChannelDto>();
        }
        return children;
    }

    public void setChildren(List<CmsChannelDto> children) {
        this.children = children;
    }
}
