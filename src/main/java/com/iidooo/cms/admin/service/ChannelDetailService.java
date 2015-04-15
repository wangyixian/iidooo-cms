package com.iidooo.cms.admin.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;

public interface ChannelDetailService {
    
    /**
     * 通过Channel ID 获取当前的Channel
     * @param channelID 通过该ID获取
     * @return CmsChannelDto对象
     */
    ChannelDto getCurrentChannel(int channelID);
    
    /**
     * 通过Channel path 获取Channel
     * @param channelPath Channel path
     * @return CmsChannelDto对象
     */
    ChannelDto getChannelByPath(String channelPath);
       
    
    
    /**
     * 创建栏目
     * @param channel 该栏目信息会被创建
     * @return 创建成功或失败
     */
    boolean createChannel(ChannelDto channel);
    
    /**
     * 更新栏目
     * @param channel 该栏目信息会被更新
     * @return 更新成功或失败
     * @throws Exception 返回的异常信息
     */
    boolean updateChannel(ChannelDto channel) throws Exception;
    
    /**
     * 删除栏目
     * @param channel 该栏目信息会被删除
     * @return 删除成功或失败
     * @throws Exception 返回的异常信息
     */
    boolean deleteChannel(ChannelDto channel) throws Exception;
}
