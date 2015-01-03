package com.iidooo.cms.client.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentTagDto;

public interface TagService {
    List<CmsContentTagDto> getContentTags(int contentID);
}
