package com.iidooo.passport.api.service;

import com.iidooo.passport.dto.extend.SecurityUserDto;

public interface ISecurityUserService {
    SecurityUserDto getSecurityUser(Integer userID);
}
