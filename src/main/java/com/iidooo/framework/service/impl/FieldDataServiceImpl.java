package com.iidooo.framework.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.FieldDataDao;
import com.iidooo.framework.dto.extend.FieldConfigDto;
import com.iidooo.framework.dto.extend.FieldDataDto;
import com.iidooo.framework.service.FieldDataService;

@Service
public class FieldDataServiceImpl implements FieldDataService {
    private static final Logger logger = Logger.getLogger(FieldConfigServiceImpl.class);

    @Autowired
    private FieldDataDao fieldDataDao;
    
    @Override
    public List<FieldDataDto> getFieldDataList(List<FieldConfigDto> fieldConfigs, int tableDataID) {
        try {
            List<FieldDataDto> fieldDataDtos = fieldDataDao.selectFieldDataList(fieldConfigs, tableDataID);
            return fieldDataDtos;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            logger.fatal(e);;
            throw e;
        }
    }
}
