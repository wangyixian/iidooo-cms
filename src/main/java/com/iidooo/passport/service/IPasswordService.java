package com.iidooo.passport.service;

import com.iidooo.passport.dto.extend.SecurityUserDto;


public interface IPasswordService {
    boolean checkOldPassword(String loginID, String oldPassword);
    
    boolean saveNewPassword(SecurityUserDto user, String newPassword);
}
