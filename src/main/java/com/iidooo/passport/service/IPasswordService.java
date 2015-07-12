package com.iidooo.passport.service;

import com.iidooo.passport.dto.extend.UserDto;


public interface IPasswordService {
    boolean checkOldPassword(String loginID, String oldPassword);
    
    boolean saveNewPassword(UserDto user, String newPassword);
}
