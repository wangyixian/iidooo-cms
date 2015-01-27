package com.iidooo.cms.dto.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsContent;

public class CmsContentDto extends CmsContent {

    private String channelName;
    
    private String templatePath;

    private List<CmsContentTagDto> tags;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public List<CmsContentTagDto> getTags() {
        return tags;
    }

    public void setTags(List<CmsContentTagDto> tags) {
        this.tags = tags;
    }
}
