package com.iidooo.cms.dto.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsContent;

public class CmsContentDto extends CmsContent {

    private String templatePath;

    private String createDate;

    private String updateDate;

    private List<CmsContentTagDto> tags;

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getCreateDate() {
        String updateTime = this.getUpdateTime();
        createDate = updateTime.substring(0, 10);
        return createDate;
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
