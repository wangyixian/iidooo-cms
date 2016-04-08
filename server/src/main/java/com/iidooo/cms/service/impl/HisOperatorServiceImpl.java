package com.iidooo.cms.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.mapper.HisOperatorMapper;
import com.iidooo.cms.model.po.HisOperator;
import com.iidooo.cms.service.HisOperatorService;
import com.iidooo.core.util.StringUtil;

@Service
public class HisOperatorServiceImpl implements HisOperatorService {

    private static final Logger logger = Logger.getLogger(HisOperatorServiceImpl.class);

    @Autowired
    private HisOperatorMapper hisOperatorMapper;

    @Override
    public void createHisOperator(String tableName, Integer tableKey, HttpServletRequest request) {
        try {

            String operation = request.getServletPath();
            // 移除斜杠
            operation = operation.substring(1);
            String operatorIP = request.getRemoteAddr();
            String userAgent = request.getHeader("User-Agent");

            // 得到操作者的UserID
            String userID = request.getParameter("userID");
            if (StringUtil.isBlank(userID)) {
                userID = request.getParameter("createUserID");
            }
            if (StringUtil.isBlank(userID)) {
                userID = "1";
            }

            HisOperator hisOperator = new HisOperator();
            hisOperator.setTableName(tableName);
            hisOperator.setTableKey(tableKey);
            hisOperator.setOperation(operation);
            hisOperator.setOperatorIP(operatorIP);
            hisOperator.setUserAgent(userAgent);
            hisOperator.setRemarks("");
            hisOperator.setCreateTime(new Date());
            hisOperator.setCreateUserID(Integer.valueOf(userID));
            hisOperator.setUpdateTime(new Date());
            hisOperator.setUpdateUserID(Integer.valueOf(userID));

            hisOperatorMapper.insert(hisOperator);
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    @Override
    public int getPVCount(String tableName, Integer tableKey, String operation) {
        int result = 0;
        try {
            // 移除斜杠
            operation = operation.substring(1);

            HisOperator hisOperator = new HisOperator();
            hisOperator.setTableName(tableName);
            hisOperator.setTableKey(tableKey);
            hisOperator.setOperation(operation);
            result = hisOperatorMapper.selectPVCount(hisOperator);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public int getUVCount(String tableName, Integer tableKey, String operation) {
        int result = 0;
        try {
            // 移除斜杠
            operation = operation.substring(1);

            HisOperator hisOperator = new HisOperator();
            hisOperator.setTableName(tableName);
            hisOperator.setTableKey(tableKey);
            hisOperator.setOperation(operation);
            result = hisOperatorMapper.selectUVCount(hisOperator);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return result;
    }

}
