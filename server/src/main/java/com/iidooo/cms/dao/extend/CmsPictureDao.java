package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsPictureDto;

public interface CmsPictureDao {
    List<CmsPictureDto> selectByContentList(List<CmsContentDto> contentList);
}
