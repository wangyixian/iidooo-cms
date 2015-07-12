package com.iidooo.passport.api.service;

import com.iidooo.passport.dto.extend.UserDto;

public interface ISecurityUserService {
    UserDto getSecurityUser(Integer userID);
}
