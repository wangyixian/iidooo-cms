package com.iidooo.framework.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.FieldModelDao;
import com.iidooo.framework.dto.extend.FieldModelDto;
import com.iidooo.framework.enumeration.TableName;
import com.iidooo.framework.service.FieldModelService;

@Service
public class FieldModelServiceImpl implements FieldModelService {

    private static final Logger logger = Logger.getLogger(FieldModelServiceImpl.class);

    @Autowired
    private FieldModelDao fieldModelDao;

    @Override
    public List<FieldModelDto> getFieldModelList(TableName tableName) {
        try {
            List<FieldModelDto> fieldModelDtos = fieldModelDao.selectByTableName(tableName.toString());
            return fieldModelDtos;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;

        }
    }
}
