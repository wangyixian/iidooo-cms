package com.iidooo.cms.mapper;

import java.util.List;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsPicture;

public interface CmsPictureMapper {
    int deleteByPrimaryKey(Integer pictureID);

    int insert(CmsPicture record);

    int insertSelective(CmsPicture record);

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