package com.iidooo.framework.dto.generate;

public class DictClass {
    private Integer dictClassID;

    private Integer dictTypeID;

    private String dictClassCode;

    private String dictClassName;

    private Integer readonlyFlag;

    private Integer disableFlag;

    private String remarks;

    private String language;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer deleteFlag;

    private Integer version;

    public Integer getDictClassID() {
        return dictClassID;
    }

    public void setDictClassID(Integer dictClassID) {
        this.dictClassID = dictClassID;
    }

    public Integer getDictTypeID() {
        return dictTypeID;
    }

    public void setDictTypeID(Integer dictTypeID) {
        this.dictTypeID = dictTypeID;
    }

    public String getDictClassCode() {
        return dictClassCode;
    }

    public void setDictClassCode(String dictClassCode) {
        this.dictClassCode = dictClassCode == null ? null : dictClassCode.trim();
    }

    public String getDictClassName() {
        return dictClassName;
    }

    public void setDictClassName(String dictClassName) {
        this.dictClassName = dictClassName == null ? null : dictClassName.trim();
    }

    public Integer getReadonlyFlag() {
        return readonlyFlag;
    }

    public void setReadonlyFlag(Integer readonlyFlag) {
        this.readonlyFlag = readonlyFlag;
    }

    public Integer getDisableFlag() {
        return disableFlag;
    }

    public void setDisableFlag(Integer disableFlag) {
        this.disableFlag = disableFlag;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}