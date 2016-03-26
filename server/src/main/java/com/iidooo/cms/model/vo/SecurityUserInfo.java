package com.iidooo.cms.model.vo;

import java.util.Date;

import com.iidooo.cms.model.po.SecurityUser;

public class SecurityUserInfo {
    private Integer userID;

    private String loginID;

    private String userName;

    private String mobile;

    private String email;

    private String sex;

    private Date birthday;

    private String weixinID;

    private String photoURL;

    private Integer isSilent;

    private Integer isDisable;

    private Integer level;

    private Integer points;
    
    public SecurityUserInfo(){
        
    }
    
    public SecurityUserInfo(SecurityUser user){
        this.setBirthday(user.getBirthday());
        this.setEmail(user.getEmail());
        this.setIsDisable(user.getIsDisable());
        this.setIsSilent(user.getIsSilent());
        this.setLevel(user.getLevel());
        this.setLoginID(user.getLoginID());
        this.setMobile(user.getMobile());
        this.setPhotoURL(user.getPhotoURL());
        this.setPoints(user.getPoints());
        this.setSex(user.getSex());
        this.setUserID(user.getUserID());
        this.setUserName(user.getUserName());
        this.setWeixinID(user.getWeixinID());
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID == null ? null : loginID.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWeixinID() {
        return weixinID;
    }

    public void setWeixinID(String weixinID) {
        this.weixinID = weixinID == null ? null : weixinID.trim();
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL == null ? null : photoURL.trim();
    }

    public Integer getIsSilent() {
        return isSilent;
    }

    public void setIsSilent(Integer isSilent) {
        this.isSilent = isSilent;
    } 
    
    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
    
    
}