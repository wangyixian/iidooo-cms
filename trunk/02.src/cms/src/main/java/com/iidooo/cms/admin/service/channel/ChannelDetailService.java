package com.iidooo.cms.admin.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;

public interface ChannelDetailService {
    
    /**
     * 通过Channel ID 获取当前的Channel
     * @param channelID 通过该ID获取
     * @return CmsChannelDto对象
     */
    CmsChannelDto getCurrentChannel(int channelID);
    
    /**
     * 通过Channel path 获取Channel
     * @param channelPath Channel path
     * @return CmsChannelDto对象
     */
    CmsChannelDto getChannelByPath(String channelPath);
       
    
    
    /**
     * 创建栏目
     * @param channel 该栏目信息会被创建
     * @return 创建成功或失败
     */
    boolean createChannel(CmsChannelDto channel);
    
    /**
     * 更新栏目
     * @param channel 该栏目信息会被更新
     * @return 更新成功或失败
     * @throws Exception 返回的异常信息
     */
    boolean updateChannel(CmsChannelDto channel) throws Exception;
    
    /**
     * 删除栏目
     * @param channel 该栏目信息会被删除
     * @return 删除成功或失败
     * @throws Exception 返回的异常信息
     */
    boolean deleteChannel(CmsChannelDto channel) throws Exception;
}
