package com.iidooo.cms.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iidooo.cms.model.po.CmsPicture;
import com.iidooo.core.model.po.SecurityUser;

public class CmsContentWrap {
    private Integer contentID;

    private Integer channelID;

    private String contentType;

    private String contentTitle;

    private String contentSubTitle;

    private String contentImageTitle;

    private String metaTitle;

    private String metaKeywords;

    private String metaDescription;

    private String contentSummary;

    private Integer isSilent;

    private Integer stickyIndex;

    private Integer pageViewCount;

    private Integer uniqueVisitorCount;

    private Integer starCount;

    private Integer commentCount;

    private String startShowDate;

    private String startShowTime;

    private String endShowDate;

    private String endShowTime;

    private String status;

    private String remarks;

    private Date createTime;

    private Integer createUserID;

    private Date updateTime;

    private Integer updateUserID;

    private Integer isDelete;

    private Integer version;

    private String contentBody;

    public Integer getContentID() {
        return contentID;
    }

    public void setContentID(Integer contentID) {
        this.contentID = contentID;
    }

    public Integer getChannelID() {
        return channelID;
    }

    public void setChannelID(Integer channelID) {
        this.channelID = channelID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle == null ? null : contentTitle.trim();
    }

    public String getContentSubTitle() {
        return contentSubTitle;
    }

    public void setContentSubTitle(String contentSubTitle) {
        this.contentSubTitle = contentSubTitle == null ? null : contentSubTitle.trim();
    }

    public String getContentImageTitle() {
        return contentImageTitle;
    }

    public void setContentImageTitle(String contentImageTitle) {
        this.contentImageTitle = contentImageTitle == null ? null : contentImageTitle.trim();
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle == null ? null : metaTitle.trim();
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords == null ? null : metaKeywords.trim();
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription == null ? null : metaDescription.trim();
    }

    public String getContentSummary() {
        return contentSummary;
    }

    public void setContentSummary(String contentSummary) {
        this.contentSummary = contentSummary == null ? null : contentSummary.trim();
    }

    public Integer getIsSilent() {
        return isSilent;
    }

    public void setIsSilent(Integer isSilent) {
        this.isSilent = isSilent;
    }

    public Integer getStickyIndex() {
        return stickyIndex;
    }

    public void setStickyIndex(Integer stickyIndex) {
        this.stickyIndex = stickyIndex;
    }

    public Integer getPageViewCount() {
        return pageViewCount;
    }

    public void setPageViewCount(Integer pageViewCount) {
        this.pageViewCount = pageViewCount;
    }

    public Integer getUniqueVisitorCount() {
        return uniqueVisitorCount;
    }

    public void setUniqueVisitorCount(Integer uniqueVisitorCount) {
        this.uniqueVisitorCount = uniqueVisitorCount;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getStartShowDate() {
        return startShowDate;
    }

    public void setStartShowDate(String startShowDate) {
        this.startShowDate = startShowDate == null ? null : startShowDate.trim();
    }

    public String getStartShowTime() {
        return startShowTime;
    }

    public void setStartShowTime(String startShowTime) {
        this.startShowTime = startShowTime == null ? null : startShowTime.trim();
    }

    public String getEndShowDate() {
        return endShowDate;
    }

    public void setEndShowDate(String endShowDate) {
        this.endShowDate = endShowDate == null ? null : endShowDate.trim();
    }

    public String getEndShowTime() {
        return endShowTime;
    }

    public void setEndShowTime(String endShowTime) {
        this.endShowTime = endShowTime == null ? null : endShowTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody == null ? null : contentBody.trim();
    }
    
    private List<CmsPicture> pictureList;

    public List<CmsPicture> getPictureList() {
        if (pictureList == null) {
            pictureList = new ArrayList<CmsPicture>();
        }
        return pictureList;
    }

    public void setPictureList(List<CmsPicture> pictureList) {
        this.pictureList = pictureList;
    }
    
    private SecurityUser createUser;

    public SecurityUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SecurityUser createUser) {
        this.createUser = createUser;
    }
    
    private List<CmsTagInfo> tagList;

    public List<CmsTagInfo> getTagList() {
        if (tagList == null) {
            tagList = new ArrayList<CmsTagInfo>();
        }
        return tagList;
    }

    public void setTagList(List<CmsTagInfo> tagList) {
        this.tagList = tagList;
    }
    
    private String source;

    private String sourceURL;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL == null ? null : sourceURL.trim();
    }
}
