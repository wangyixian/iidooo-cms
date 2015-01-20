package com.iidooo.framework.dao.extend;

import java.util.List;

import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.extend.DictItemDto;

public interface DictItemDao {

    /**
     * 根据字典类查询字典项的List
     * 
     * @param classCode 字典类Code
     * @return List<SysDictItem> 字典项一览
     */
    List<DictItemDto> selectByClassCode(String classCode);
    
    /**
     * Select the DictItemDto by the item code
     * @param itemCode The item code
     * @return The DictItemDto
     */
    DictItemDto selectByItemCode(String itemCode);

    /**
     * 查询获得所有记录数
     * 
     * @return 记录总数
     */
    int selectAllCount();

    /**
     * 分页的方式查询所有的字典项
     * 
     * @param dto 分页对象
     * @return List<SysDictItem> 字典项一览
     */
    List<DictItemDto> selectAll(PagingDto dto);
}