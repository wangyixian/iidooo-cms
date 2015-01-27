package com.iidooo.framework.dao.extend;

import java.util.List;

import com.iidooo.framework.dto.extend.SecurityUserDto;

public interface SecurityUserDao {
    SecurityUserDto selectByLoginID(String loginID);
    
    /**
     * Get all of the users
     * @return The users list
     */
    List<SecurityUserDto> selectAll();
}
