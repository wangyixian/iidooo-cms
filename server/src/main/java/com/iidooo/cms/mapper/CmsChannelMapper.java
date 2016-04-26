package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.messaging.handler.annotation.Payload;

import com.iidooo.cms.model.po.CmsChannel;
import com.iidooo.core.model.Page;

public interface CmsChannelMapper {
    int deleteByPrimaryKey(Integer channelID);

    int insert(CmsChannel record);

    int insertSelective(CmsChannel record);
    
    /**
     * 查询栏目一览
     * @return 得到栏目一览列表
     */
    List<CmsChannel> selectChannelList();

    int updateByPrimaryKeySelective(CmsChannel record);

    int updateByPrimaryKey(CmsChannel record);
}