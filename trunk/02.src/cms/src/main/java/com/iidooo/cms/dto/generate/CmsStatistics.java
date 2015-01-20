package com.iidooo.cms.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class CmsStatistics extends BaseDto{
    private Integer statisticsID;

    private String tableName;

    private Integer tableDataID;

    private String statisticsIP;

    private Integer statisticsType;

    private Integer statisticsValue;

    public Integer getStatisticsID() {
        return statisticsID;
    }

    public void setStatisticsID(Integer statisticsID) {
        this.statisticsID = statisticsID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableDataID() {
        return tableDataID;
    }

    public void setTableDataID(Integer tableDataID) {
        this.tableDataID = tableDataID;
    }

    public String getStatisticsIP() {
        return statisticsIP;
    }

    public void setStatisticsIP(String statisticsIP) {
        this.statisticsIP = statisticsIP == null ? null : statisticsIP.trim();
    }

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

    public Integer getStatisticsValue() {
        return statisticsValue;
    }

    public void setStatisticsValue(Integer statisticsValue) {
        this.statisticsValue = statisticsValue;
    }

}