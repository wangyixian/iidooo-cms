package com.iidooo.cms.dto.generate;

public class CmsStatistics {
    private Integer statisticsID;

    private String tableName;

    private Integer tableDataID;

    private String statisticsIP;

    private Integer statisticsType;

    private Integer statisticsValue;

    private String remarks;

    private String language;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer isDelete;

    private Integer version;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}