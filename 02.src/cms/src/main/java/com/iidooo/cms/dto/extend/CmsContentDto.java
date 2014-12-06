package com.iidooo.cms.dto.extend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.generate.CmsContent;

public class CmsContentDto extends CmsContent {

    private String templateSource;

    private String updateDate;

    private List<CmsContentTagDto> tags;

    public String getTemplateSource() {
        return templateSource;
    }

    public void setTemplateSource(String templateSource) {
        this.templateSource = templateSource;
    }

    public String getUpdateDate() {
        String updateTime = this.getUpdateTime();
        updateDate = updateTime.substring(0, 10);
        return updateDate;
    }

    public List<CmsContentTagDto> getTags() {
        return tags;
    }

    public void setTags(List<CmsContentTagDto> tags) {
        this.tags = tags;
    }
}
