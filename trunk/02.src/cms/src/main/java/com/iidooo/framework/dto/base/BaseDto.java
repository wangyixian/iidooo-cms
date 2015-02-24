package com.iidooo.framework.dto.base;

import com.iidooo.framework.constant.DateConstant;
import com.iidooo.framework.utility.DateTimeUtil;

public class BaseDto {
    private String remarks;

    private String createTime;

    private Integer createUser;
    
    private String createUserName;

    private String updateTime;

    private Integer updateUser;
    
    private String updateUserName;

    private Integer isDelete;

    private Integer version;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateDate() {
        String updateDate = DateTimeUtil.format(updateTime, DateConstant.FORMAT_DATETIME, DateConstant.FORMAT_DATE);
        return updateDate;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
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

    public void setCommonData(int userID, String dataTime, boolean isCreate) {
        if (isCreate) {
            this.createUser = userID;
            this.createTime = dataTime;
        }
        this.updateUser = userID;
        this.updateTime = dataTime;
        if (remarks == null) {
            remarks = "";
        }
    }
}
