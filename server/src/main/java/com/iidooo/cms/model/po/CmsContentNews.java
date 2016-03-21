package com.iidooo.cms.model.po;


public class CmsContentNews extends CmsContent{
    private Integer contentID;

    private String source;

    private String sourceURL;

    public Integer getContentID() {
        return contentID;
    }

    public void setContentID(Integer contentID) {
        this.contentID = contentID;
    }

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