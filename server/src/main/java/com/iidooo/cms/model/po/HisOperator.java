package com.iidooo.cms.model.po;

import java.util.Date;

public class HisOperator {
    private Integer hisID;

    private String tableName;

    private Integer tableKey;

    private String operatorIP;

    private String operatorMac;

    private String operatorBrowser;

    private String operationCode;

    private String remarks;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer isDelete;

    private Integer version;

    public Integer getHisID() {
        return hisID;
    }

    public void setHisID(Integer hisID) {
        this.hisID = hisID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableKey() {
        return tableKey;
    }

    public void setTableKey(Integer tableKey) {
        this.tableKey = tableKey;
    }

    public String getOperatorIP() {
        return operatorIP;
    }

    public void setOperatorIP(String operatorIP) {
        this.operatorIP = operatorIP == null ? null : operatorIP.trim();
    }

    public String getOperatorMac() {
        return operatorMac;
    }

    public void setOperatorMac(String operatorMac) {
        this.operatorMac = operatorMac == null ? null : operatorMac.trim();
    }

    public String getOperatorBrowser() {
        return operatorBrowser;
    }

    public void setOperatorBrowser(String operatorBrowser) {
        this.operatorBrowser = operatorBrowser == null ? null : operatorBrowser.trim();
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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