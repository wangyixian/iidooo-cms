package com.iidooo.cms.dto.generate;

public class ContentBlog {
    private Integer contentID;

    private String blogTag;

    private String blogType;

    private Integer isTemp;

    private Integer preBlogID;

    private Integer nextBlogID;

    public Integer getContentID() {
        return contentID;
    }

    public void setContentID(Integer contentID) {
        this.contentID = contentID;
    }

    public String getBlogTag() {
        return blogTag;
    }

    public void setBlogTag(String blogTag) {
        this.blogTag = blogTag == null ? null : blogTag.trim();
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType == null ? null : blogType.trim();
    }

    public Integer getIsTemp() {
        return isTemp;
    }

    public void setIsTemp(Integer isTemp) {
        this.isTemp = isTemp;
    }

    public Integer getPreBlogID() {
        return preBlogID;
    }

    public void setPreBlogID(Integer preBlogID) {
        this.preBlogID = preBlogID;
    }

    public Integer getNextBlogID() {
        return nextBlogID;
    }

    public void setNextBlogID(Integer nextBlogID) {
        this.nextBlogID = nextBlogID;
    }
}