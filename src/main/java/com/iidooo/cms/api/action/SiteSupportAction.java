package com.iidooo.cms.api.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dto.PageDto;
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

    private List<ContentDto> contentList;

    private List<ContentProductDto> productList;

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

    public List<ContentDto> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentDto> contentList) {
        this.contentList = contentList;
    }

    public List<ContentProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ContentProductDto> productList) {
        this.productList = productList;
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
            this.channel = (ChannelDto) JSONObject.toBean(jsonObject, ChannelDto.class);
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
            this.content = (ContentDto) JSONObject.toBean(jsonObject, ContentDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    /**
     * Send the API request of get content, just return one content.
     * 
     * @param siteCode The site code of searching content.
     * @param channelPath The channel path of searching content
     */
    public void sendGetContentAPI(String siteCode, String channelPath) {
        try {
            String cmsURL = (String) this.getApplicationValue(CmsConstant.CMS_URL);

            // Get the content by the API content
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENT, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            this.content = (ContentDto) JSONObject.toBean(jsonObject, ContentDto.class);
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
            this.product = (ContentProductDto) JSONObject.toBean(jsonObject, ContentProductDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void sendGetProductListAPI(String siteCode, String channelPath, ContentProductDto product) {
        try {
            String cmsURL = (String) this.getApplicationValue(CmsConstant.CMS_URL);

            PageDto page = this.getPage();
            if (page == null) {
                page = new PageDto();
            }
            
            if (product == null) {
                product = new ContentProductDto();
            }

            // Get the content by the API content
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            data.put(CmsConstant.FIELD_CONTENT_PRODUCT_COUNTRY, product.getProductCountry());
            data.put(CmsConstant.FIELD_CONTENT_PRODUCT_ORIGIN, product.getProductOrigin());
            data.put(CoreConstants.FIELD_PAGE_START, page.getStart());
            data.put(CoreConstants.FIELD_PAGE_SIZE, page.getPageSize());
            data.put(CoreConstants.FIELD_PAGE_SORT_FIELD, page.getSortField());
            data.put(CoreConstants.FIELD_PAGE_SORT_TYPE, page.getSortType());

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENT_PRODUCTS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);

            JSONObject jsonPage = jsonObject.getJSONObject(CoreConstants.REST_API_RESULT_PAGE);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.REST_API_RESULT_LIST);

            this.setPage((PageDto) JSONObject.toBean(jsonPage, PageDto.class));
            this.productList = (List<ContentProductDto>) JSONArray.toCollection(jsonArray, ContentProductDto.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void sendGetContentListAPI(String siteCode, String channelPath) {
        try {
            String cmsURL = (String) this.getApplicationValue(CmsConstant.CMS_URL);

            PageDto page = this.getPage();
            if (page == null) {
                page = new PageDto();
            }

            // Get the content by the API content
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            data.put(CoreConstants.FIELD_PAGE_START, page.getStart());
            data.put(CoreConstants.FIELD_PAGE_SIZE, page.getPageSize());
            data.put(CoreConstants.FIELD_PAGE_SORT_FIELD, page.getSortField());
            data.put(CoreConstants.FIELD_PAGE_SORT_TYPE, page.getSortType());

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENTS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);

            JSONObject jsonPage = jsonObject.getJSONObject(CoreConstants.REST_API_RESULT_PAGE);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.REST_API_RESULT_LIST);

            this.setPage((PageDto) JSONObject.toBean(jsonPage, PageDto.class));
            this.contentList = (List<ContentDto>) JSONArray.toCollection(jsonArray, ContentDto.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
