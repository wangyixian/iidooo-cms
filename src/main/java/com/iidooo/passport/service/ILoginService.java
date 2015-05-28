package com.iidooo.passport.service;

import com.iidooo.passport.dto.extend.SecurityUserDto;

public interface ILoginService {
    SecurityUserDto login(String loginID, String password);
}
