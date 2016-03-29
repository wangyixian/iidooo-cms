package com.iidooo.cms.service;

import javax.servlet.http.HttpServletRequest;

public interface HisOperatorService {
    void createHisOperator(String tableName, Integer tableKey, HttpServletRequest request);
    
    int getPVCount(String tableName, Integer tableKey, HttpServletRequest request);
    
    int getUVCount(String tableName, Integer tableKey, HttpServletRequest request);
}
