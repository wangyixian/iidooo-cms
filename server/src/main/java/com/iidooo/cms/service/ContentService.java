package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsContentNews;
import com.iidooo.core.model.Page;

public interface ContentService {
    
    /**
     * 通过内容类型和内容ID获取内容对象
     * @param contentType 内容类型的枚举
     * @param contentID 内容ID
     * @return 所获的的内容对象
     */
    CmsContent getContent(String contentType, Integer contentID);
    
    List<CmsContent> getContentListByType(String channelPath, CmsContent cmsContent, Page page);
    
    CmsContent createContent(CmsContent content) throws Exception;
    
    CmsContentNews createContentNews(CmsContentNews contentNews)  throws Exception;
    
    /**
     * 更新内容的PV和UV
     * @param contentID 该内容的PV和UV会被统计
     * @param pvCount pv数量
     * @param uvCount uv数量
     */
    void updateViewCount(Integer contentID, int pvCount, int uvCount);
}
