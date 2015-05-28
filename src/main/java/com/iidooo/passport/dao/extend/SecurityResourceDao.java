package com.iidooo.passport.dao.extend;

import java.util.List;

import com.iidooo.passport.dto.extend.SecurityResourceDto;

public interface SecurityResourceDao {
    List<SecurityResourceDto> selectAll();
}
