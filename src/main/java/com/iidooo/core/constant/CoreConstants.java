package com.iidooo.core.constant;

public class CoreConstants {

    public static final String BEAN_DICT_ITEM_DAO = "dictItemDao";
    
    public static final String DICT_CLASS_CORE_PAGE = "DICT_CLASS_CORE_PAGE";
    public static final String DICT_CLASS_CORE_UPLOAD = "DICT_CLASS_CORE_UPLOAD";
    
    public static final String DICT_ITEM_PAGE_SIZE = "DICT_ITEM_PAGE_SIZE";
    public static final String DICT_ITEM_IMAGE_MAX_SIZE = "DICT_ITEM_IMAGE_MAX_SIZE";
    
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_PUT = "PUT";
    public static final String HTTP_METHOD_DELETE = "DELETE";

    public static final String REST_API_RESULT_LIST = "REST_API_RESULT_LIST";
    public static final String REST_API_RESULT_PAGE = "REST_API_RESULT_PAGE";
    
    public static final String REST_API_DICT_ITEMS = "dictItems";

    // The core web application URL, saved in the session use this key.
    public static final String CORE_URL = "CORE_URL";

    // The regular expression of email
    public static final String REGEX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    // The regular expression of half English
    public static final String REGEX_ENGLISH = "^[a-zA-Z]*";
    // The regular expression of half English and number
    public static final String REGEX_ENGLISH_NUMBER = "^[A-Za-z0-9]+$";
    
    public static final String ENCODING_UTF8 = "UTF-8";

    public static final String CHARSET_UTF8 = "charset=UTF-8";

    public static final String APPLICATION_JSON = "application/json";

    public static final String TEXT_JSON = "text/json";

    public static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

    public static final String FIELD_DICT_CLASS_CODE = "dictClassCode";

    public static final String FIELD_DICT_ITEM_CODE = "dictItemCode";

    public static final String FIELD_DICT_ITEM_NAME = "dictItemName";

    public static final String FIELD_DICT_ITEM_LIST = "dictItemList";
    
    // The field of page dto's start
    public static final String FIELD_PAGE_START = "start";
    // The field of page dto's end
    public static final String FIELD_PAGE_END = "end";
    // The field of page dto's size
    public static final String FIELD_PAGE_SIZE = "size";
    // The field of page dto's sort field
    public static final String FIELD_PAGE_SORT_FIELD = "sortField";
    // The field of page dto's sort type
    public static final String FIELD_PAGE_SORT_TYPE = "sortType";


    // The sort type of ascending
    public static final String SORT_TYPE_ASC = "asc";
    // The sort type of descending
    public static final String SORT_TYPE_DESC = "desc";
    
    // The sort field as sequence
    public static final String SORT_FIELD_SEQUENCE = "Sequence";
    // The sort field as update time
    public static final String SORT_FIELD_UPDATETIME = "UpdateTime";
    public static final String SORT_FIELD_PAGE_VIEWED = "PageViewed";
    public static final String SORT_FIELD_UNIQUE_VISITOR = "UniqueVisitor";
}
