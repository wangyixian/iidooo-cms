package com.iidooo.cms.service.content.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.IContentListService;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.PageUtil;
import com.iidooo.passport.filter.SSOFilter;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ContentListService implements IContentListService {

    private static final Logger logger = Logger.getLogger(ContentListService.class);

    private ChannelDao channelDao;

    private ContentDao contentDao;

    @Override
    public List<ContentDto> getContentListByChannel(Integer channelID, PageDto page) {
        List<ContentDto> result = new ArrayList<ContentDto>();
        try {
            if (channelID == null || channelID <= 0) {
                int count = contentDao.selectAllCount();
                page = PageUtil.executePage(count, page);
                result = contentDao.selectAll(page);
            } else {
                List<Integer> channels = getOffspringChannelList(channelID);
                int count = contentDao.selectContentListCountByChannels(channels);
                page = PageUtil.executePage(count, page);
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
            int userID = (int) sessionMap.get(SSOFilter.USER_ID);
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

    private List<Integer> getOffspringChannelList(Integer channelID) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            result.add(channelID);

            List<ChannelDto> channelList = channelDao.selectAll();
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
