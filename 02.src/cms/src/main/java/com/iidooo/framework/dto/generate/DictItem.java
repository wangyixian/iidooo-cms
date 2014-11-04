package com.iidooo.framework.dto.generate;

public class DictItem {
    private Integer dictItemID;

    private Integer dictClassID;

    private Integer parentItemID;

    private Integer dictItemCode;

    private String dictItemName;

    private String dictItemValue;

    private Integer weight;

    private Integer isDefault;

    private String remarks;

    private String language;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer isReadonly;

    private Integer isDisable;

    private Integer isDelete;

    private Integer version;

    public Integer getDictItemID() {
        return dictItemID;
    }

    public void setDictItemID(Integer dictItemID) {
        this.dictItemID = dictItemID;
    }

    public Integer getDictClassID() {
        return dictClassID;
    }

    public void setDictClassID(Integer dictClassID) {
        this.dictClassID = dictClassID;
    }

    public Integer getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(Integer parentItemID) {
        this.parentItemID = parentItemID;
    }

    public Integer getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(Integer dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName == null ? null : dictItemName.trim();
    }

    public String getDictItemValue() {
        return dictItemValue;
    }

    public void setDictItemValue(String dictItemValue) {
        this.dictItemValue = dictItemValue == null ? null : dictItemValue.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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

    public Integer getIsReadonly() {
        return isReadonly;
    }

    public void setIsReadonly(Integer isReadonly) {
        this.isReadonly = isReadonly;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
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