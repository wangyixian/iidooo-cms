package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentTagDto;

public interface CmsContentTagDao {
    List<CmsContentTagDto> selectTagsByContentID(int contentID);
}
