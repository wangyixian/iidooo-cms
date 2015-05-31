package com.iidooo.cms.api.action;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.HttpUtil;

public class SiteSupportAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(SiteSupportAction.class);

    private ChannelDto channel;

    private ContentDto content;

    private ContentProductDto product;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public ContentDto getContent() {
        return content;
    }

    public void setContent(ContentDto content) {
        this.content = content;
    }

    public ContentProductDto getProduct() {
        return product;
    }

    public void setProduct(ContentProductDto product) {
        this.product = product;
    }

    public void sendGetChannelAPI(String siteCode, String channelPath) {
        try {
            String cmsURL = (String) this.getApplicationValue(CmsConstant.CMS_URL);

            // Get the channel by the API channel
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CHANNEL, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            this.channel = (ChannelDto) JSONObject.toBean(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void sendGetContentAPI(int contentID) {
        try {
            String cmsURL = (String) this.getApplicationValue(CmsConstant.CMS_URL);

            // Get the content by the API content
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_CONTENT_ID, contentID);
            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENT, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            this.content = (ContentDto) JSONObject.toBean(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void sendGetContentProductAPI(int contentID) {
        try {
            String cmsURL = (String) this.getApplicationValue(CmsConstant.CMS_URL);

            // Get the content by the API content
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_CONTENT_ID, contentID);
            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENT_PRODUCT, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            this.product = (ContentProductDto) JSONObject.toBean(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
