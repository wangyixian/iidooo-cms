package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.CmsChannel;

public class CmsChannelDto extends CmsChannel {
    private String templateSource;

    private int level;

    public String getTemplateSource() {
        return templateSource;
    }

    public void setTemplateSource(String templateSource) {
        this.templateSource = templateSource;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
