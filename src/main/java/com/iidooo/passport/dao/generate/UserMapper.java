package com.iidooo.passport.dao.generate;

import com.iidooo.passport.dto.generate.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}