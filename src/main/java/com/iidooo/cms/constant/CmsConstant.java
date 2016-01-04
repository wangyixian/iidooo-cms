package com.iidooo.cms.constant;

public class CmsConstant {


    public static final String BEAN_SITE_DAO = "siteDao";
    public static final String BEAN_CHANNEL_DAO = "channelDao";
    
    public static final String CMS_URL = "CMS_URL";
    
    // channelList的Action，带parentID参数
    public static final String ACTION_CHANNEL_LIST = "channelList.action?channel.parentID={0}";
    // channelDetail的Action, 带channelID参数
    public static final String ACTION_CHANNEL_DETAIL = "channelDetail.action?channel.channelID={0}";
    
    // The channel path "index" is a special define.
    public static final String CHANNEL_PATH_INDEX = "index";
    
    // The content type of default
    public static final String DICT_ITEM_CONTENT_TYPE_DEFAULT = "01";
    // The content type of product
    public static final String DICT_ITEM_CONTENT_TYPE_PRODUCT = "02";
    
    // The CMS System's Restful API define
    public static final String REST_API_SITE = "site";
    public static final String REST_API_CHANNEL = "channel";
    public static final String REST_API_CHANNELS = "channels";
    public static final String REST_API_CONTENT = "content";
    public static final String REST_API_CONTENT_PRODUCT="product";
    public static final String REST_API_CONTENTS = "contents";
    public static final String REST_API_CONTENT_PRODUCTS = "products";

    public static final String FIELD_META_TITLE = "metaTitle";
    public static final String FIELD_META_KEYWORDS = "metaKeywords";
    public static final String FIELD_META_DESCRIPTION = "metaDescription"; 
    
    public static final String FIELD_SITE_CODE = "siteCode";    
    public static final String FIELD_SITE_URL = "siteURL";
    
    public static final String FIELD_CHANNEL_ID = "channelID";
    public static final String FIELD_CHANNEL_PATH = "channelPath";    
    public static final String FIELD_CHANNEL_NAME = "channelName";
    public static final String FIELD_CHANNEL_LEVEL = "channelLevel";
    public static final String FIELD_CHANNEL_PARENT_ID = "parentID";
    public static final String FIELD_CHANNEL_PARENT_PATH = "parentPath";
    public static final String FIELD_CHANNEL_IS_HIDDEN = "isHidden";
    
    public static final String FIELD_CONTENT_ID = "contentID";    
    public static final String FIELD_CONTENT_TITLE = "contentTitle";
    public static final String FIELD_CONTENT_IMAGE_TITLE = "contentImageTitle";
    public static final String FIELD_CONTENT_UPDATE_DATE = "updateDate";
    public static final String FIELD_CONTENT_SUMMARY = "contentSummary";
    
    public static final String FIELD_CONTENT_PRODUCT_COUNTRY = "productCountry";
    public static final String FIELD_CONTENT_PRODUCT_ORIGIN = "productOrigin";
}
