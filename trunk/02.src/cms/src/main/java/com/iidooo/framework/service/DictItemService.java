package com.iidooo.framework.service;

import java.util.List;

import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.extend.DictItemDto;

/**
 * SysDictItem处理的共通Service接口
 * 
 * @author 李辉
 * 
 */
public interface DictItemService {

	/**
	 * 根据字典项的code获取字典项
	 * 
	 * @param dictItemCode 字典项的Code
	 * @return SysDictItem 字典项Dto
	 */
    DictItemDto getDictItemByItemCode(String dictItemCode);

    List<DictItemDto> getByClassCode(String dictClassCode);
    
	/**
	 * Get the DictItemDto list by the array of DictClassCode
	 * 
	 * @param dictClassCodes The array of DictClassCode
	 * @return The list of DictItemDto
	 */
	List<DictItemDto> getByClassCode(List<String> dictClassCodes);

	/**
	 * 得到字典项总数
	 * 
	 * @return 字典项总数
	 */
	int getDictItemsCount();

	/**
	 * 以分页的方式得到字典项
	 * 
	 * @param pagingDto 分页对象
	 * @return List<SysDictItem>字典项一览
	 */
	List<DictItemDto> getDictItems(PagingDto pagingDto);
}
