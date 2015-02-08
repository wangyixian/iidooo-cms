package com.iidooo.framework.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.framework.dto.extend.FieldConfigDto;
import com.iidooo.framework.dto.extend.FieldDataDto;

public interface FieldDataDao {
    
    /**
     * Get the FieldDataList by a table data ID and some field configurations.
     * @param fieldConfigs
     * @param tableDataID
     * @return
     */
    List<FieldDataDto> selectFieldDataList(@Param("fieldConfigs")List<FieldConfigDto> fieldConfigs, @Param("tableDataID")int tableDataID);
    
    /**
     * Insert the FieldDataDto
     * @param fieldData
     * @return
     */
    int insert(FieldDataDto fieldData);
    
    int updateByPrimaryKey(FieldDataDto fieldData);
    
    int deleteByPrimaryKey(FieldDataDto fieldData);
}
