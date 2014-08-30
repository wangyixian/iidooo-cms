package com.iidooo.framework.dao.extend;

import java.util.List;

import com.iidooo.framework.dao.generate.DictItemMapper;
import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.generate.DictItem;

public interface DictItemDao extends DictItemMapper{
    /**
     * 根据 dictItemCode 查询 dictItemValue
     * 
     * @param dictItemCode 字典项的Code
     * @return dictItemValue 字典项的Value
     */
    DictItem selectByItemCode(String dictItemCode);

    /**
     * 根据字典类的Code查询字典项的List
     * 
     * @param dictClassCode 字典类的Code
     * @return List<SysDictItem> 字典项一览
     */
    List<DictItem> selectByClassCode(String dictClassCode);

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
    List<DictItem> selectAll(PagingDto dto);
}