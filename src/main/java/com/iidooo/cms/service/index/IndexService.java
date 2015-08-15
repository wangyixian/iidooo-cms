package com.iidooo.cms.service.index;

import java.util.List;

import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.passport.dto.extend.RoleDto;

public interface IndexService {
    List<SiteDto> getSiteList(List<RoleDto> roleList);
}
