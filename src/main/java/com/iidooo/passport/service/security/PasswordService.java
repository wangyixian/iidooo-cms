package com.iidooo.passport.service.security;

import com.iidooo.passport.dto.extend.UserDto;


public interface PasswordService {
    boolean checkOldPassword(String loginID, String oldPassword);
    
    boolean saveNewPassword(UserDto user, String newPassword);
}
