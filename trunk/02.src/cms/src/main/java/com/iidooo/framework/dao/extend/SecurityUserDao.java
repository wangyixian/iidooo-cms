package com.iidooo.framework.dao.extend;

import com.iidooo.framework.dto.extend.SecurityUserDto;

public interface SecurityUserDao {
    SecurityUserDto selectByLoginID(String loginID);
}
