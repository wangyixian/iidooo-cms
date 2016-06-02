package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.core.model.Page;

public interface ContentService {
    
    /**
     * 通过内容类型和内容ID获取内容对象
     * @param contentID 内容ID
     * @return 所获的的内容对象
     */
    CmsContent getContent(Integer contentID);
    
    /**
     * 通过内容类型和内容ID获取内容对象
     * @param contentID 内容ID
     * @param userID 为了在content对象上设置是否被该用户收藏的Flag
     * @return 所获的的内容对象
     */    
    CmsContent getContent(Integer contentID, Integer userID);
    
    /**
     * 根据内容信息获得内容
     * @param createUserID 内容创建者
     * @param contentType 内容类型
     * @param contentBody 内容体
     * @return 所获得的内容对象
     */
    CmsContent getContentByInfo(Integer createUserID, String contentType, String contentBody);
    
    List<CmsContent> getContentListByType(String channelPath, CmsContent cmsContent, Page page);
    
    int getContentListCount(CmsContent cmsContent, String startDate, String endDate);
    
    List<CmsContent> getContentList(CmsContent cmsContent, String startDate, String endDate, Page page);
    
    boolean createContent(CmsContent content) throws Exception;
    
    boolean updateContent(CmsContent content, boolean isPicutureListUpdate) throws Exception;
        
    /**
     * 得到点赞数
     * @param contentID 获得该内容ID的点赞数
     * @return 点赞数
     */
    int getContentStarCount(Integer contentID);
    
    /**
     * 得到指定用户的内容数
     * @param userID 该用户ID所创建的内容数
     * @param contentType 统计的内容类型
     * @return 内容数量
     */
    int getUserContentCount(Integer userID, String contentType);
    
    /**
     * 得到所有的PV数量
     * @return PV总数
     */
    int getPVCountSum();
    
    /**
     * 更新内容的PV和UV
     * @param contentID 该内容的PV和UV会被统计
     * @param pvCount pv数量
     * @param uvCount uv数量
     */
    void updateViewCount(Integer contentID, int pvCount, int uvCount);
    
    /**
     * 更新内容的评论数
     * @param contentID 指定内容的ID
     */
    void updateCommentCount(Integer contentID);
    
    /**
     * 删除指定内容
     * @param content 该内容会被删除
     * @return 删除成功还是失败
     */
    boolean deleteContent(CmsContent content);
}
