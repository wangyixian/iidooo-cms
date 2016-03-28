package com.iidooo.cms.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.mapper.SecurityUserMapper;
import com.iidooo.cms.model.po.SecurityUser;
import com.iidooo.cms.model.vo.SecurityUserInfo;
import com.iidooo.cms.service.SecurityUserService;
import com.iidooo.core.util.SecurityUtil;
import com.iidooo.core.util.StringUtil;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {

    private static final Logger logger = Logger.getLogger(SecurityUserServiceImpl.class);

    @Autowired
    private SecurityUserMapper securityUserMapper;

    @Override
    public SecurityUserInfo getUserInfoByID(Integer userID) {
        try {
            SecurityUserInfo result = securityUserMapper.selectByUserID(userID);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public SecurityUserInfo createDefaultUser(String photoBaseURL) {
        try {
            SecurityUser user = new SecurityUser();
            user.setLoginID(StringUtil.getRandomStr(6));
            user.setPassword(SecurityUtil.getMd5("123456"));
            user.setUserName(user.getLoginID());
            user.setBirthday(new Date());
            user.setEmail("");
            user.setIsDisable(0);
            user.setIsSilent(0);
            user.setLevel(0);
            user.setMobile("");
            user.setPhotoURL(photoBaseURL + CmsConstant.UPLOAD_DEFAULT_PHOTO_FILE_PATH);
            user.setPoints(0);
            user.setSex("2");
            user.setWeixinID("");
            user.setUserType("2");
            user.setCreateTime(new Date());
            user.setCreateUserID(1);
            user.setUpdateTime(new Date());
            user.setUpdateUserID(1);
            // 创建用户失败
            if (securityUserMapper.insertSelective(user) <= 0) {
                return null;
            }
            
            // 为了用户唯一性，用UserID再更新一遍用户名
            user.setUserName(user.getUserName() + user.getUserID().toString());
            user.setLoginID(user.getUserName());
            if(securityUserMapper.updateByUserID(user) <= 0){
                return null;
            }
            
            SecurityUserInfo result = new SecurityUserInfo(user);
            
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public SecurityUserInfo updateUserInfo(SecurityUserInfo userInfo) {
        try {
            SecurityUser user = new SecurityUser();
            user.setUserName(userInfo.getUserName());
            user.setBirthday(userInfo.getBirthday());
            user.setEmail(userInfo.getEmail());
            user.setIsDisable(userInfo.getIsDisable());
            user.setIsSilent(userInfo.getIsSilent());
            user.setLevel(userInfo.getLevel());
            user.setMobile(userInfo.getMobile());
            user.setPhotoURL(userInfo.getPhotoURL());
            user.setPoints(userInfo.getPoints());
            user.setSex(userInfo.getSex());
            user.setWeixinID(userInfo.getWeixinID());
            user.setUpdateTime(new Date());
            user.setUpdateUserID(userInfo.getUserID());
            // 更新失败
            if (securityUserMapper.updateByUserID(user) <= 0) {
                return null;
            }
                        
            SecurityUserInfo result = new SecurityUserInfo(user);
            
            return result;
            
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }
}
