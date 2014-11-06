package com.iidooo.framework.dao.extend;

import java.util.List;

import com.iidooo.framework.dao.generate.DictItemMapper;
import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.extend.DictClassDto;
import com.iidooo.framework.dto.extend.DictItemDto;

public interface DictItemDao extends DictItemMapper{
    
    /**
     * 根据字典类查询字典项的List
     * 
     * @param DictClassDto 字典类
     * @return List<SysDictItem> 字典项一览
     */
    List<DictItemDto> selectByDictClass(DictClassDto dictClassDto);

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