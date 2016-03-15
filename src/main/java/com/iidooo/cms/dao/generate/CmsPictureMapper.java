package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsPicture;

public interface CmsPictureMapper {
    int deleteByPrimaryKey(Integer pictureID);

    int insert(CmsPicture record);

    int insertSelective(CmsPicture record);

    CmsPicture selectByPrimaryKey(Integer pictureID);

    int updateByPrimaryKeySelective(CmsPicture record);

    int updateByPrimaryKey(CmsPicture record);
}