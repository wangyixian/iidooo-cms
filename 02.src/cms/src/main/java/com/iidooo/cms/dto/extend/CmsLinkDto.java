package com.iidooo.cms.dto.extend;

import java.util.ArrayList;
import java.util.List;

import com.iidooo.cms.dto.generate.CmsLink;

public class CmsLinkDto extends CmsLink {
    
    public CmsLinkDto(){
        children = new ArrayList<CmsLinkDto>();
        subringPageIDs = new ArrayList<Integer>();
    }
    
    private List<CmsLinkDto> children;
    
    private List<Integer> subringPageIDs;

    public List<CmsLinkDto> getChildren() {
        return children;
    }

    public void setChildren(List<CmsLinkDto> children) {
        this.children = children;
    }

    public List<Integer> getSubringPageIDs() {
        return subringPageIDs;
    }

    public void setSubringPageIDs(List<Integer> subringPageIDs) {
        this.subringPageIDs = subringPageIDs;
    }    
}
