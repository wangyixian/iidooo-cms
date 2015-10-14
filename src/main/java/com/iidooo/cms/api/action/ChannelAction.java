package com.iidooo.cms.api.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.IChannelService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.action.common.BaseAPIAction;
import com.iidooo.core.constant.HttpConstant;
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
            case HttpConstant.METHOD_GET:

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
            case HttpConstant.METHOD_GET:

                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);
                String parentPath = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_PARENT_PATH);
                if (siteCode == null || siteCode.isEmpty()) {
                    return;
                }

                List<ChannelDto> channelList = new ArrayList<ChannelDto>();

                channelList = channelService.getChannelChildre(siteCode, parentPath);

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
