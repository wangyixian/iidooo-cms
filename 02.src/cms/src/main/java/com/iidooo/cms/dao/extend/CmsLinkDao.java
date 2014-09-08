package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsLinkDto;

public interface CmsLinkDao {

    List<CmsLinkDto> selectByBlockID(Integer blockID);
    
    List<CmsLinkDto> selectByParentLinkID(Integer parentLinkID);
}