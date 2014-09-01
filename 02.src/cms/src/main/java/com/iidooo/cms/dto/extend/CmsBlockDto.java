package com.iidooo.cms.dto.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsBlock;

public class CmsBlockDto extends CmsBlock {
    private List<CmsLinkDto> cmsLinks;

    public List<CmsLinkDto> getCmsLinks() {
        return cmsLinks;
    }

    public void setCmsLinks(List<CmsLinkDto> cmsLinks) {
        this.cmsLinks = cmsLinks;
    }
}
