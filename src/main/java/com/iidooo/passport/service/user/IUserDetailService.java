package com.iidooo.passport.service.user;


import com.iidooo.passport.dto.extend.UserDto;


public interface IUserDetailService {

    /**
     * Get user by primary id
     *  
     * @param userID The user id to get the user.
     * @return The gotten user.
     */
    UserDto getUserByID(int userID);
    
    boolean isLoginIDDuplicate(String loginID);

    boolean createUser(UserDto user);

    boolean updateUser(UserDto user);

}
