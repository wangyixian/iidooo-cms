package com.iidooo.cms.service.content.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelContentDao;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.IContentListService;
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
    
    @Autowired
    private ChannelContentDao channelContentDao;

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
            
            // Delete the channel content relationship.
            int result = channelContentDao.deleteContent(content.getChannelID(), content.getContentID());
            if (result <= 0) {
                return false;
            }
            
            // If there is no relationship of this content and any channel, delete the content from Content Table.
            if (channelContentDao.selectContentCount(content.getContentID()) <= 0) {
                Map<String, Object> sessionMap = ActionContext.getContext().getSession();
                int userID = (int) sessionMap.get(PassportConstant.USER_ID);
                content.setUpdateUser(userID);
                content.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
                int count = contentDao.deleteByPrimaryKey(content);
                if (count <= 0) {
                    return false;
                }
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

            List<ChannelDto> channelList = channelDao.selectChannelsBySite(siteCode);
            this.counstructChildren(channelList);

            for (ChannelDto item : channelList) {
                if (item.getChannelID() == channelID) {
                    appendOffspringChannels(item.getChildren(), result);
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    private void counstructChildren(List<ChannelDto> channelList) {
        try {
            Map<Integer, ChannelDto> channelMap = new HashMap<Integer, ChannelDto>();
            for (ChannelDto item : channelList) {
                channelMap.put(item.getChannelID(), item);
            }

            for (ChannelDto item : channelList) {
                int parentID = item.getParentID();

                // The root channel skip
                if (parentID <= 0) {
                    continue;
                }

                ChannelDto parentChannel = channelMap.get(parentID);
                parentChannel.getChildren().add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void appendOffspringChannels(List<ChannelDto> children, List<Integer> offspringChannels) {
        try {
            for (ChannelDto child : children) {
                offspringChannels.add(child.getChannelID());
                this.appendOffspringChannels(child.getChildren(), offspringChannels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
