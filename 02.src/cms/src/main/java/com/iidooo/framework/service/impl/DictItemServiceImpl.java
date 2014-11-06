package com.iidooo.framework.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.generate.DictItem;
import com.iidooo.framework.service.DictItemService;

/**
 * SysDictItem处理的共通Service实现
 * 
 * @author wangyixian
 * 
 */
@Service
public class DictItemServiceImpl implements DictItemService {

	/**
	 * SysDictItemServiceImpl的Logger处理
	 */
	private static final Logger logger = Logger.getLogger(DictItemServiceImpl.class);

	/**
	 * 字典项的数据处理类
	 */
	@Autowired
	private DictItemDao sysDictItemDao;

	public DictItem getDictItemByItemCode(String dictItemCode) {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItemByItemCode");
		DictItem sysDictItem = null;
		try {
			//sysDictItem = sysDictItemDao.selectByItemCode(dictItemCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}

		logger.debug("The end of the method PropertyValueServiceImpl.getDictItemByItemCode");
		return sysDictItem;
	}

	public List<DictItem> getDictItemsByClassCode(String dictClassCode) {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItemsByClassCode");

		List<DictItem> sysDictItems = null;
		try {
			//sysDictItems = sysDictItemDao.selectByClassCode(dictClassCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}

		logger.debug("The end of the method PropertyValueServiceImpl.getDictItemsByClassCode");
		return sysDictItems;
	}

	public int getDictItemsCount() {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItemsCount");

		int sum = 0;

		try {
			sum = sysDictItemDao.selectAllCount();
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}

		logger.debug("The end of the method PropertyValueServiceImpl.getDictItemsCount");
		return sum;
	}

	public List<DictItem> getDictItems(PagingDto pagingDto) {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItems");

		List<DictItem> dictItems = null;
		try {
			//dictItems = sysDictItemDao.selectAll(pagingDto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}
		
		logger.debug("The end of the method PropertyValueServiceImpl.getDictItems");
		return dictItems;
	}
}
