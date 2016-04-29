package com.iidooo.cms.mapper;

import java.util.List;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsPicture;

public interface CmsPictureMapper {
    
    /**
     * 根据内容ID把图片列表删掉
     * @param contentID 内容ID
     * @return 所影响的行数
     */
    int deleteByContentID(Integer contentID);

    /**
     * 插入图片数据
     * @param picture 该图片数据会被插入数据库
     * @return 所影响的行数
     */
    int insert(CmsPicture picture);

    CmsPicture selectByPrimaryKey(Integer pictureID);

    int updateByPrimaryKeySelective(CmsPicture record);

    int updateByPrimaryKey(CmsPicture record);
    
    /**
     * 根据内容一览List获得所有相关联的图片一览
     * @param contentList 内容一览
     * @return 图片一览List对象
     */
    List<CmsPicture> selectByContentList(List<CmsContent> contentList);
}