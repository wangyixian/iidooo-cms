package com.iidooo.framework.dto.base;

import com.iidooo.core.util.DateUtil;
import com.iidooo.framework.constant.DateConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;

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

    private SecurityUserDto sessionUser;

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
        String updateDate = DateUtil.format(updateTime, DateConstant.FORMAT_DATETIME, DateConstant.FORMAT_DATE);
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

    public SecurityUserDto getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(SecurityUserDto sessionUser) {
        this.sessionUser = sessionUser;
    }

    public void setCommonData(boolean isCreate) {
        String now = DateUtil.getNow(DateConstant.FORMAT_DATETIME);

        if (isCreate) {
            this.createUser = sessionUser.getUserID();
            this.createTime = now;
        }
        
        this.updateUser = sessionUser.getUserID();
        this.updateTime = now;
        if (remarks == null) {
            remarks = "";
        }
    }
}
