package com.iidooo.framework.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.FieldConfigDao;
import com.iidooo.framework.dto.extend.FieldConfigDto;
import com.iidooo.framework.service.FieldConfigService;

@Service
public class FieldConfigServiceImpl implements FieldConfigService{
    
    private static final Logger logger = Logger.getLogger(FieldConfigServiceImpl.class);

    @Autowired
    private FieldConfigDao fieldConfigDao;
    
    @Override
    public List<FieldConfigDto> getFieldConfigList(int modelID) {
        try {
            List<FieldConfigDto> fieldConfigDtos = fieldConfigDao.selectByModelID(modelID);
            return fieldConfigDtos;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
    
}
