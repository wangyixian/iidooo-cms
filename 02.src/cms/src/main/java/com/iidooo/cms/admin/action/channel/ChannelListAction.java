package com.iidooo.cms.admin.action.channel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.channel.ChannelListService;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.action.PagingActionSupport;

public class ChannelListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelListService channelListService;

    private List<CmsChannelDto> allChannels;

    private List<CmsChannelDto> channelList;
    
    private int currentChannelID = 0;

    public List<CmsChannelDto> getAllChannels() {
        return allChannels;
    }

    public void setAllChannels(List<CmsChannelDto> allChannels) {
        this.allChannels = allChannels;
    }

    public List<CmsChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<CmsChannelDto> channelList) {
        this.channelList = channelList;
    }

    public int getCurrentChannelID() {
        return currentChannelID;
    }

    public void setCurrentChannelID(int currentChannelID) {
        this.currentChannelID = currentChannelID;
    }

    public String init() {
        try {
            channelList = new ArrayList<CmsChannelDto>();
            allChannels = channelListService.getAllChannelList();

            Map<Integer, CmsChannelDto> channelMap = new HashMap<Integer, CmsChannelDto>();
            for (CmsChannelDto cmsChannelDto : allChannels) {
                if (cmsChannelDto.getChannelLevel() == 1) {
                    channelList.add(cmsChannelDto);
                }
                channelMap.put(cmsChannelDto.getChannelID(), cmsChannelDto);
            }

            // Set the children
            for (CmsChannelDto cmsChannelDto : allChannels) {
                if (cmsChannelDto.getParentID() != 0) {
                    CmsChannelDto parent = channelMap.get(cmsChannelDto.getParentID());
                    parent.getChildren().add(cmsChannelDto);
                }
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
