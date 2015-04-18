package com.iidooo.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.base.PageDto;
import com.iidooo.framework.dto.extend.DictItemDto;
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

	private static final Logger logger = Logger.getLogger(DictItemServiceImpl.class);

	@Autowired
	private DictItemDao dictItemDao;

	public DictItemDto getDictItemByItemCode(String dictItemCode) {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItemByItemCode");
		DictItemDto sysDictItem = null;
		try {
			sysDictItem = dictItemDao.selectByItemCode(dictItemCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}

		logger.debug("The end of the method PropertyValueServiceImpl.getDictItemByItemCode");
		return sysDictItem;
	}	
	
	@Override
    public List<DictItemDto> getByClassCode(String dictClassCode) {
	    List<DictItemDto> sysDictItems = new ArrayList<DictItemDto>();
        try {
            sysDictItems = dictItemDao.selectByClassCode(dictClassCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return sysDictItems;
    }



    @Override
	public List<DictItemDto> getByClassCode(List<String> dictClassCodes) {
		List<DictItemDto> sysDictItems = new ArrayList<DictItemDto>();
		try {
			sysDictItems = dictItemDao.selectByClassCodes(dictClassCodes);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e);
		}
		return sysDictItems;
	}

	public int getDictItemsCount() {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItemsCount");

		int sum = 0;

		try {
			sum = dictItemDao.selectAllCount();
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}

		logger.debug("The end of the method PropertyValueServiceImpl.getDictItemsCount");
		return sum;
	}

	public List<DictItemDto> getDictItems(PageDto pagingDto) {
		logger.debug("The begin of the method PropertyValueServiceImpl.getDictItems");

		List<DictItemDto> dictItems = null;
		try {
			dictItems = dictItemDao.selectAll(pagingDto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}
		
		logger.debug("The end of the method PropertyValueServiceImpl.getDictItems");
		return dictItems;
	}
}
