package com.iidooo.cms.dto.generate;

public class CmsArticle {
    private Integer articleID;

    private Integer pageID;

    private String articleTitle;

    private String articleSubTitle;

    private String articleCode;

    private String articleSummary;

    private String articleKeywords;

    private String articlePublishTime;

    private String articleAuthor;

    private Integer nextArticleID;

    private Integer preArticleID;

    private Integer noCommentFlag;

    private Integer disableFlag;

    private Integer visiteTimes;

    private String remarks;

    private String language;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer deleteFlag;

    private Integer version;

    private String articleContent;

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public Integer getPageID() {
        return pageID;
    }

    public void setPageID(Integer pageID) {
        this.pageID = pageID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleSubTitle() {
        return articleSubTitle;
    }

    public void setArticleSubTitle(String articleSubTitle) {
        this.articleSubTitle = articleSubTitle == null ? null : articleSubTitle.trim();
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode == null ? null : articleCode.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }

    public String getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(String articleKeywords) {
        this.articleKeywords = articleKeywords == null ? null : articleKeywords.trim();
    }

    public String getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(String articlePublishTime) {
        this.articlePublishTime = articlePublishTime == null ? null : articlePublishTime.trim();
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    public Integer getNextArticleID() {
        return nextArticleID;
    }

    public void setNextArticleID(Integer nextArticleID) {
        this.nextArticleID = nextArticleID;
    }

    public Integer getPreArticleID() {
        return preArticleID;
    }

    public void setPreArticleID(Integer preArticleID) {
        this.preArticleID = preArticleID;
    }

    public Integer getNoCommentFlag() {
        return noCommentFlag;
    }

    public void setNoCommentFlag(Integer noCommentFlag) {
        this.noCommentFlag = noCommentFlag;
    }

    public Integer getDisableFlag() {
        return disableFlag;
    }

    public void setDisableFlag(Integer disableFlag) {
        this.disableFlag = disableFlag;
    }

    public Integer getVisiteTimes() {
        return visiteTimes;
    }

    public void setVisiteTimes(Integer visiteTimes) {
        this.visiteTimes = visiteTimes;
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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}