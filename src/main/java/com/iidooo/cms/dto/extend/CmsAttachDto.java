package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.CmsAttach;

public class CmsAttachDto extends CmsAttach {
    private String templateSource;
    
    private String albumTitle;

    public String getTemplateSource() {
        return templateSource;
    }

    public void setTemplateSource(String templateSource) {
        this.templateSource = templateSource;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
    
    
}
