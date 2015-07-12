package com.iidooo.passport.dao.extend;

import java.util.List;

import com.iidooo.passport.dto.extend.ResourceDto;

public interface ResourceDao {
    List<ResourceDto> selectAll();
}
