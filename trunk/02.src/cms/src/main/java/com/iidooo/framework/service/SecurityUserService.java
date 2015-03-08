package com.iidooo.framework.service;

import java.util.List;

import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.extend.SecurityUserDto;

public interface SecurityUserService {
    
    int getAllUsersCount();
    
    List<SecurityUserDto> getAllUsers(PagingDto page);
}
