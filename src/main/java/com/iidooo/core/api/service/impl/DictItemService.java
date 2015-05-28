package com.iidooo.core.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.core.api.service.IDictItemService;
import com.iidooo.core.dao.extend.DictItemDao;
import com.iidooo.core.dto.extend.DictItemDto;

@Service
public class DictItemService implements IDictItemService {
    private static final Logger logger = Logger.getLogger(DictItemService.class);

    @Autowired
    private DictItemDao dictItemDao;
    
    @Override
    public List<DictItemDto> getDictItemList(String dictClassCode) {
        List<DictItemDto> result = new ArrayList<DictItemDto>();
        try {
            result = dictItemDao.selectByClassCode(dictClassCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }
}
