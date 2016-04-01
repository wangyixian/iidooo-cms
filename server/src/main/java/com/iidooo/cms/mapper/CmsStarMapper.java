package com.iidooo.cms.mapper;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsStar;

public interface CmsStarMapper {
    int deleteByPrimaryKey(Integer startID);

    /**
     * 插入一个点赞
     * @param cmsStar 点赞数据
     * @return 插入所影响的行数
     */
    int insert(CmsStar cmsStar);

    /**
     * 根据内容的ContentID和点赞用户的CreateUserID查找已存在的赞对象
     * @param contentID 内容ID
     * @param createUserID 点赞用户ID
     * @return CmsStar对象
     */
    CmsStar selectByUserContentID(@Param("contentID")Integer contentID, @Param("createUserID")Integer createUserID);
    
    /**
     * 更新点赞数据
     * @param cmsStar 该对象的记录会被更新
     * @return 更新所影响的行数
     */
    int update(CmsStar cmsStar);

    int updateByPrimaryKey(CmsStar record);
}