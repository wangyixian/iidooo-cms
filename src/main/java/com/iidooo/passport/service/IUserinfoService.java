package com.iidooo.passport.service;

import java.util.List;

import com.iidooo.passport.dto.extend.UserDto;

public interface IUserinfoService {
    
    UserDto getUser(String loginID);
    
    boolean saveUser(UserDto user);
}
