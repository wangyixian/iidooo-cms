package com.iidooo.framework.service;

import com.iidooo.framework.dto.extend.SecurityUserDto;

public interface LoginService {
    SecurityUserDto auth(String loginID, String password);
}
