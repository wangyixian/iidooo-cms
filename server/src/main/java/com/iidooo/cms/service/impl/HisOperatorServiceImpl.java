package com.iidooo.cms.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.mapper.HisOperatorMapper;
import com.iidooo.cms.model.po.HisOperator;
import com.iidooo.cms.service.HisOperatorService;

@Service
public class HisOperatorServiceImpl implements HisOperatorService {

    private static final Logger logger = Logger.getLogger(HisOperatorServiceImpl.class);

    @Autowired
    private HisOperatorMapper hisOperatorMapper;

    @Override
    public void createHisOperator(String tableName, Integer tableKey, HttpServletRequest request) {
        try {

            String operation = request.getServletPath();
            String operatorIP = request.getRemoteAddr();
            String userAgent = request.getHeader("User-Agent");
            
            HisOperator hisOperator = new HisOperator();
            hisOperator.setTableName(tableName);
            hisOperator.setTableKey(tableKey);
            hisOperator.setOperation(operation);
            hisOperator.setOperatorIP(operatorIP);
            hisOperator.setUserAgent(userAgent);
            hisOperator.setRemarks("");
            hisOperator.setCreateTime(new Date());
            hisOperator.setCreateUserID(1);
            hisOperator.setUpdateTime(new Date());
            hisOperator.setUpdateUserID(1);
            
            hisOperatorMapper.insert(hisOperator);
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    @Override
    public int getPVCount(String tableName, Integer tableKey, HttpServletRequest request) {
        int result = 0;
        try {
            HisOperator hisOperator = new HisOperator();
            hisOperator.setTableName(tableName);
            hisOperator.setTableKey(tableKey);
            hisOperator.setOperation(request.getServletPath());
            result = hisOperatorMapper.selectPVCount(hisOperator);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public int getUVCount(String tableName, Integer tableKey, HttpServletRequest request) {
        int result = 0;
        try {
            HisOperator hisOperator = new HisOperator();
            hisOperator.setTableName(tableName);
            hisOperator.setTableKey(tableKey);
            hisOperator.setOperation(request.getServletPath());
            result = hisOperatorMapper.selectUVCount(hisOperator);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return result;
    }

}
