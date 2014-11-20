package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsAttachAlbum;

public interface CmsAttachAlbumMapper {
    int deleteByPrimaryKey(Integer albumID);

    int insert(CmsAttachAlbum record);

    int insertSelective(CmsAttachAlbum record);

    CmsAttachAlbum selectByPrimaryKey(Integer albumID);

    int updateByPrimaryKeySelective(CmsAttachAlbum record);

    int updateByPrimaryKey(CmsAttachAlbum record);
}