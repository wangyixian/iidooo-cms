package com.iidooo.passport.dao.extend;

import com.iidooo.passport.dto.extend.UserDto;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
    
    UserDto selectByPrimaryKey(Integer userID);
    
    UserDto selectForLogin(@Param("loginID")String loginID, @Param("password")String password);
    
    UserDto selectByLoginID(String loginID);
    
    int updateByPrimaryKey(UserDto user);
    
    int updatePassword(UserDto user);
}
