package com.iidooo.cms.service.content.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.IContentListService;
import com.iidooo.cms.util.ChannelUtil;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ContentListService implements IContentListService {

    private static final Logger logger = Logger.getLogger(ContentListService.class);

    @Autowired
    private ChannelDao channelDao;

    @Autowired
    private ContentDao contentDao;   

    @Override
    public int getContentListCount(Integer channelID, String siteCode) {
        int result = 0;
        try {
            if (channelID == null || channelID <= 0) {
                result = contentDao.selectAllCount();
            } else {
                List<Integer> channels = getOffspringChannelList(channelID, siteCode);
                result = contentDao.selectContentListCountByChannels(channels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public List<ContentDto> getContentList(Integer channelID, PageDto page, String siteCode) {
        List<ContentDto> result = new ArrayList<ContentDto>();
        try {
            if (channelID == null || channelID <= 0) {
                result = contentDao.selectAll(page);
            } else {
                List<Integer> channels = getOffspringChannelList(channelID, siteCode);
                result = contentDao.selectContentListByChannels(channels, page);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public boolean deleteContent(ContentDto content) {
        try {
            
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            int userID = (int) sessionMap.get(PassportConstant.USER_ID);
            content.setUpdateUser(userID);
            content.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            int count = contentDao.deleteByPrimaryKey(content);
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

    private List<Integer> getOffspringChannelList(Integer channelID, String siteCode) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            result.add(channelID);

            ChannelUtil channelUtil = new ChannelUtil(channelDao);
            
            List<ChannelDto> channelList = channelDao.selectBySiteCode(siteCode);
            channelUtil.counstructChildren(channelList);

            result = channelUtil.getOffspring(channelList, channelID);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    

    
}
