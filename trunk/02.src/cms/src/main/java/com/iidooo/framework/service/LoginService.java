package com.iidooo.framework.service;

import java.util.Map;

import com.iidooo.framework.dto.extend.SecurityUserDto;

public interface LoginService {
    SecurityUserDto auth(String loginID, String password);
    
    /**
     * Get all of the users map
     * @return The map key:userID value:userName
     */
    Map<Integer, String> getUsersMap();
}
