package com.iidooo.cms.service.channel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.SiteDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.channel.IChannelListService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.RoleDto;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ChannelListService implements IChannelListService {

    private static final Logger logger = Logger.getLogger(ChannelListService.class);

    @Autowired
    private ChannelDao channelDao;
    
    @Autowired
    private SiteDao siteDao;

    @Override
    public List<ChannelDto> getChildrenChannelList(int parentID, int siteID) {
        List<ChannelDto> result = new ArrayList<ChannelDto>();
        try {
            ChannelDto channel = new ChannelDto();
            channel.setParentID(parentID);
            channel.setSiteID(siteID);
            result = channelDao.selectChannelList(channel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public List<SiteDto> getSiteList(List<RoleDto> roleList) {
        List<SiteDto> result = new ArrayList<SiteDto>();
        try {
            result = siteDao.selectSiteList(roleList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public boolean deleteChannel(ChannelDto channel) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            int userID = (int) sessionMap.get(PassportConstant.USER_ID);
            channel.setUpdateUser(userID);
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            int count = channelDao.deleteByPrimaryKey(channel);
            if (count <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

}
