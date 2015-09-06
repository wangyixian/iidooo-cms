package com.iidooo.passport.service.user;

import java.util.List;

import com.iidooo.core.dto.PageDto;
import com.iidooo.passport.dto.extend.UserDto;

public interface UserListService {
    UserDto getUser(int userId);   

    
    int getUserListCount();

    List<UserDto> getUserList( PageDto page);
   /**
     * Delete the user
     * 
     * @param user This user should be delete.
     * @return Delete success or not.
     */
    boolean deleteUser(UserDto user);

}
