package com.iidooo.cms.dto.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsAttachAlbum;

public class CmsAttachAlbumDto extends CmsAttachAlbum {
    
    private Integer preAlbumID;
    
    private Integer nextAlbumID;
    
    private String classifyName;
    
    private String templateSource;
    
    private List<CmsAttachDto> cmsAttachDtos;

    public Integer getPreAlbumID() {
        return preAlbumID;
    }

    public void setPreAlbumID(Integer preAlbumID) {
        this.preAlbumID = preAlbumID;
    }

    public Integer getNextAlbumID() {
        return nextAlbumID;
    }

    public void setNextAlbumID(Integer nextAlbumID) {
        this.nextAlbumID = nextAlbumID;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getTemplateSource() {
        return templateSource;
    }

    public void setTemplateSource(String templateSource) {
        this.templateSource = templateSource;
    }

    public List<CmsAttachDto> getCmsAttachDtos() {
        return cmsAttachDtos;
    }

    public void setCmsAttachDtos(List<CmsAttachDto> cmsAttachDtos) {
        this.cmsAttachDtos = cmsAttachDtos;
    }
}
