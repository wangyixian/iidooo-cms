package com.iidooo.passport.service.user;

import com.iidooo.passport.dto.extend.UserDto;

public interface UserinfoService {
    
    UserDto getUser(String loginID);
    
    boolean saveUser(UserDto user);
}
