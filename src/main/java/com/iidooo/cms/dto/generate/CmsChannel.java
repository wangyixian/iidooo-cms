package com.iidooo.cms.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class CmsChannel extends BaseDto{
    private Integer channelID;

    private Integer parentID;

    private String channelName;

    private String channelPath;

    private Integer channelLevel;

    private String metaTitle;

    private String metaKeywords;

    private String metaDescription;

    private Integer sequence;

    private String isHidden;

    public Integer getChannelID() {
        return channelID;
    }

    public void setChannelID(Integer channelID) {
        this.channelID = channelID;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getChannelPath() {
        return channelPath;
    }

    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath == null ? null : channelPath.trim();
    }

    public Integer getChannelLevel() {
        return channelLevel;
    }

    public void setChannelLevel(Integer channelLevel) {
        this.channelLevel = channelLevel;
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden == null ? null : isHidden.trim();
    }
}