package com.iidooo.cms.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iidooo.cms.dto.extend.ChannelDto;

public class ChannelUtil {

    private static final Logger logger = Logger.getLogger(ChannelUtil.class);

    public void counstructChildren(List<ChannelDto> channelList) {
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

    public List<Integer> getOffspring(List<ChannelDto> channelList, int currentChannelID) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            result.add(currentChannelID);
            for (ChannelDto item : channelList) {
                if (item.getChannelID() == currentChannelID) {
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
    
    public List<Integer> getOffspring(List<ChannelDto> channelList, String currentChannelPath){
        List<Integer> result = new ArrayList<Integer>();
        try {
            
            for (ChannelDto item : channelList) {
                if (item.getChannelPath().equals(currentChannelPath)) {
                    
                    // First add the channel's self in the offspring return result list.
                    result.add(item.getChannelID());
                    
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

    public void appendOffspringChannels(List<ChannelDto> children, List<Integer> offspringChannels) {
        try {
            for (ChannelDto child : children) {
                offspringChannels.add(child.getChannelID());
                appendOffspringChannels(child.getChildren(), offspringChannels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
