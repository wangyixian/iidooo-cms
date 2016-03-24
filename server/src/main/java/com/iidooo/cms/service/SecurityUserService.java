package com.iidooo.cms.service;

import com.iidooo.cms.model.vo.SecurityUserInfo;

public interface SecurityUserService {
    SecurityUserInfo getUserInfoByID(Integer userID);
    
    SecurityUserInfo createDefaultUser();
}
