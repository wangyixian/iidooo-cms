package com.iidooo.cms.api.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.IChannelService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.action.BaseAPIAction;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.util.JsonUtil;

public class ChannelAction extends BaseAPIAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelAction.class);

    @Autowired
    private IChannelService channelService;

    public void channel() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case CoreConstants.HTTP_METHOD_GET:

                // The restful API of get channel by site code and channel path
                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);
                String channelPath = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_PATH);
                if (siteCode == null || siteCode.isEmpty() || channelPath == null || channelPath.isEmpty()) {
                    return;
                }

                ChannelDto channel = channelService.getChannel(siteCode, channelPath);

                JsonUtil.responseObject(channel, this.getResponse());
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void channels() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case CoreConstants.HTTP_METHOD_GET:

                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);
                if (siteCode == null || siteCode.isEmpty()) {
                    return;
                }

                List<ChannelDto> channelList = new ArrayList<ChannelDto>();

                String isHidden = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_IS_HIDDEN);
                String channelLevel = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_LEVEL);
                if (isHidden != null && !isHidden.isEmpty()) {
                    if (channelLevel != null) {
                        channelList = channelService.getDisplayChannelList(siteCode, Integer.parseInt(channelLevel));
                    } else {
                        channelList = channelService.getDisplayChannelList(siteCode, Integer.MAX_VALUE);
                    }
                } else {
                    if (channelLevel != null) {
                        channelList = channelService.getChannelList(siteCode, Integer.parseInt(channelLevel));
                    } else {
                        channelList = channelService.getChannelList(siteCode, Integer.MAX_VALUE);
                    }
                }

                JsonUtil.responseObjectArray(channelList, this.getResponse());
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
