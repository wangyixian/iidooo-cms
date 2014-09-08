package com.iidooo.cms.dto.generate;

public class CmsLink {
    private Integer linkID;

    private Integer linkPageID;

    private Integer linkArticleID;

    private Integer parentLinkID;

    private String linkTitle;

    private String linkSubTitle;

    private String linkImageURL;

    private String linkCode;

    private String linkURL;

    private String linkTarget;

    private String linkDescription;

    private String remarks;

    private String language;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer deleteFlag;

    private Integer version;

    public Integer getLinkID() {
        return linkID;
    }

    public void setLinkID(Integer linkID) {
        this.linkID = linkID;
    }

    public Integer getLinkPageID() {
        return linkPageID;
    }

    public void setLinkPageID(Integer linkPageID) {
        this.linkPageID = linkPageID;
    }

    public Integer getLinkArticleID() {
        return linkArticleID;
    }

    public void setLinkArticleID(Integer linkArticleID) {
        this.linkArticleID = linkArticleID;
    }

    public Integer getParentLinkID() {
        return parentLinkID;
    }

    public void setParentLinkID(Integer parentLinkID) {
        this.parentLinkID = parentLinkID;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle == null ? null : linkTitle.trim();
    }

    public String getLinkSubTitle() {
        return linkSubTitle;
    }

    public void setLinkSubTitle(String linkSubTitle) {
        this.linkSubTitle = linkSubTitle == null ? null : linkSubTitle.trim();
    }

    public String getLinkImageURL() {
        return linkImageURL;
    }

    public void setLinkImageURL(String linkImageURL) {
        this.linkImageURL = linkImageURL == null ? null : linkImageURL.trim();
    }

    public String getLinkCode() {
        return linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode == null ? null : linkCode.trim();
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL == null ? null : linkURL.trim();
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget == null ? null : linkTarget.trim();
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription == null ? null : linkDescription.trim();
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