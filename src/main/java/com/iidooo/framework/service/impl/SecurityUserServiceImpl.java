package com.iidooo.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.SecurityUserDao;
import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.service.SecurityUserService;

@Service
public class SecurityUserServiceImpl implements SecurityUserService{

    private static final Logger logger = Logger.getLogger(DictItemServiceImpl.class);
    
    @Autowired
    private SecurityUserDao securityUserDao;
    
    @Override
    public int getAllUsersCount() {
        try {
            int resultValue = securityUserDao.selectAllCount();
            return resultValue;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return 0;
        }
    }

    @Override
    public List<SecurityUserDto> getAllUsers(PagingDto page) {
        List<SecurityUserDto> resultList = new ArrayList<SecurityUserDto>();
        try {
            resultList = securityUserDao.selectAll(page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return resultList;
    }

}
