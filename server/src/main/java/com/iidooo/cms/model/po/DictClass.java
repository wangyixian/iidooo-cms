package com.iidooo.cms.model.po;

import java.util.Date;

public class DictClass {
    private Integer dictClassID;

    private String dictTypeCode;

    private String dictClassCode;

    private String dictClassName;

    private Integer sequence;

    private String remarks;

    private Date createTime;

    private Integer createUserID;

    private Date updateTime;

    private Integer updateUserID;

    private Integer isDelete;

    private Integer version;

    public Integer getDictClassID() {
        return dictClassID;
    }

    public void setDictClassID(Integer dictClassID) {
        this.dictClassID = dictClassID;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    public Integer getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(Integer createUserID) {
        this.createUserID = createUserID;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserID() {
        return updateUserID;
    }

    public void setUpdateUserID(Integer updateUserID) {
        this.updateUserID = updateUserID;
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