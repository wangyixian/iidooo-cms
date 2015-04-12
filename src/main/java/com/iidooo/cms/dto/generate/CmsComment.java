package com.iidooo.cms.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class CmsComment extends BaseDto{
    private Integer commentID;

    private String tableName;

    private Integer tableDataID;

    private Integer parentCommentID;

    private String comment;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableDataID() {
        return tableDataID;
    }

    public void setTableDataID(Integer tableDataID) {
        this.tableDataID = tableDataID;
    }

    public Integer getParentCommentID() {
        return parentCommentID;
    }

    public void setParentCommentID(Integer parentCommentID) {
        this.parentCommentID = parentCommentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}