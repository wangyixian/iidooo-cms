package com.iidooo.passport.service;

import java.util.List;

import com.iidooo.passport.dto.extend.SecurityUserDto;

public interface IUserinfoService {
    
    SecurityUserDto getUser(String loginID);
    
    boolean saveUser(SecurityUserDto user);
}
