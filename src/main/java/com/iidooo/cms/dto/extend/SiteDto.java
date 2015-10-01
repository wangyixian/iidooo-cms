package com.iidooo.cms.dto.extend;

import com.iidooo.cms.dto.generate.Site;
import com.iidooo.core.util.DateUtil;

public class SiteDto extends Site implements java.io.Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String createUserName;
    
    private String updateUserName;
    
    private String createDate;
    
    private String updateDate;
    
    private int channelSum;
    
    private int contentSum;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getCreateDate() {
        createDate = DateUtil.format(this.getCreateTime(), DateUtil.FORMAT_DATETIME, DateUtil.FORMAT_DATE);
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        updateDate = DateUtil.format(this.getUpdateTime(), DateUtil.FORMAT_DATETIME, DateUtil.FORMAT_DATE);
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getChannelSum() {
        return channelSum;
    }

    public void setChannelSum(int channelSum) {
        this.channelSum = channelSum;
    }

    public int getContentSum() {
        return contentSum;
    }

    public void setContentSum(int contentSum) {
        this.contentSum = contentSum;
    }
    
    
}
