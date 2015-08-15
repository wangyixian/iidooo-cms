package com.iidooo.passport.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.core.dto.PageDto;
import com.iidooo.passport.dto.extend.UserDto;

public interface UserDao {
    
    UserDto selectByPrimaryKey(Integer userID);
    
    UserDto selectForLogin(@Param("loginID")String loginID, @Param("password")String password);
    
    UserDto selectByLoginID(String loginID);
    
    int selectAllCount();

    List<UserDto> selectAll(PageDto page);
    
    int updateByPrimaryKey(UserDto user);
    
    int updateLoginTime(UserDto user);
    
    int updatePassword(UserDto user);
    
    int insert(UserDto user);

    int update(UserDto user);

    int delete(UserDto user);
}
