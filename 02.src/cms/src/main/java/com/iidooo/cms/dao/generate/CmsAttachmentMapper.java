package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsAttachment;

public interface CmsAttachmentMapper {
    int deleteByPrimaryKey(Integer attachID);

    int insert(CmsAttachment record);

    int insertSelective(CmsAttachment record);

    CmsAttachment selectByPrimaryKey(Integer attachID);

    int updateByPrimaryKeySelective(CmsAttachment record);

    int updateByPrimaryKey(CmsAttachment record);
}