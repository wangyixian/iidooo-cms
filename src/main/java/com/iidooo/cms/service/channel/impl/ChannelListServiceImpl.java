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
import com.iidooo.cms.service.channel.ChannelListService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ChannelListServiceImpl implements ChannelListService {

    private static final Logger logger = Logger.getLogger(ChannelListServiceImpl.class);

    @Autowired
    private ChannelDao channelDao;

    @Autowired
    private SiteDao siteDao;

    @Override
    public ChannelDto getChannel(int channelID) {
        try {
            ChannelDto result = channelDao.selectByChannelID(channelID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public boolean hasChildren(int parentID) {
        try {
            ChannelDto channel = new ChannelDto();
            channel.setParentID(parentID);
            int count = channelDao.selectChannelListCount(channel);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public List<ChannelDto> getChildrenChannelList(int parentID) {
        List<ChannelDto> result = new ArrayList<ChannelDto>();
        try {
            ChannelDto channel = new ChannelDto();
            channel.setParentID(parentID);
            result = channelDao.selectChannelList(channel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public List<ChannelDto> getChildrenChannelList(int siteID, int parentID) {
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
    public SiteDto getTopSite() {
        try {
            SiteDto result = siteDao.selectTopSite();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteChannel(ChannelDto channel) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto use = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            channel.setUpdateUser(use.getUserID());
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            int count = channelDao.deleteByChannelID(channel);
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
