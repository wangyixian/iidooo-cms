package com.iidooo.cms.service.index;

import java.util.List;

import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.core.dto.extend.SecurityRoleDto;

public interface IndexService {
    List<SiteDto> getSiteList(List<SecurityRoleDto> roleList);
}
