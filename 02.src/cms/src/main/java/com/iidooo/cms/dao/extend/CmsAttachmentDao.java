package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dao.generate.CmsAttachmentMapper;
import com.iidooo.cms.dto.extend.CmsAttachmentDto;

public interface CmsAttachmentDao extends CmsAttachmentMapper {
    List<CmsAttachmentDto> selectByArticleID(int articleID);
}