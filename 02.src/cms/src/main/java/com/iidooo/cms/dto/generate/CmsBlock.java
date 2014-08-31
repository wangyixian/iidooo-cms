package com.iidooo.cms.dto.generate;

public class CmsBlock {
    private Integer blockID;

    private String blockTitle;

    private String blockSubTitle;

    private String blockImageTitle;

    private String blockName;

    private String remarks;

    private String language;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer deleteFlag;

    private Integer version;

    public Integer getBlockID() {
        return blockID;
    }

    public void setBlockID(Integer blockID) {
        this.blockID = blockID;
    }

    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle == null ? null : blockTitle.trim();
    }

    public String getBlockSubTitle() {
        return blockSubTitle;
    }

    public void setBlockSubTitle(String blockSubTitle) {
        this.blockSubTitle = blockSubTitle == null ? null : blockSubTitle.trim();
    }

    public String getBlockImageTitle() {
        return blockImageTitle;
    }

    public void setBlockImageTitle(String blockImageTitle) {
        this.blockImageTitle = blockImageTitle == null ? null : blockImageTitle.trim();
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName == null ? null : blockName.trim();
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