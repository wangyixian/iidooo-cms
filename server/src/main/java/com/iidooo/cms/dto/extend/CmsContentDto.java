package com.iidooo.cms.dto.extend;

import java.util.ArrayList;
import java.util.List;

import com.iidooo.cms.dto.generate.CmsContent;

public class CmsContentDto extends CmsContent {
    private List<CmsPictureDto> pictureList;

    public List<CmsPictureDto> getPictureList() {
        if (pictureList == null) {
            pictureList = new ArrayList<CmsPictureDto>();
        }
        return pictureList;
    }

    public void setPictureList(List<CmsPictureDto> pictureList) {
        this.pictureList = pictureList;
    }

}
