package com.iidooo.passport.dao.extend;

import com.iidooo.passport.dto.extend.SecurityUserDto;

import org.apache.ibatis.annotations.Param;

public interface SecurityUserDao {
    
    SecurityUserDto selectByPrimaryKey(Integer userID);
    
    SecurityUserDto selectForLogin(@Param("loginID")String loginID, @Param("password")String password);
    
    SecurityUserDto selectByLoginID(String loginID);
    
    int updateByPrimaryKey(SecurityUserDto user);
    
    int updatePassword(SecurityUserDto user);
}
