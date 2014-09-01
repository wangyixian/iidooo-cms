package com.iidooo.framework.action;

import org.apache.log4j.Logger;

import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.dto.generate.DictItem;


/**
 * 执行分页的基础Action类
 * 
 * @author wangyixian
 * 
 */
public class PagingActionSupport extends BaseAction {
	private static final Logger logger = Logger.getLogger(PagingActionSupport.class);

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * 分页用Dto
	 */
	private PagingDto pagingDto;

	/**
	 * 分页用Dto的Get方法
	 * 
	 * @return PagingDto
	 */
	public PagingDto getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用Dto的Set方法
	 * 
	 * @param pagingDto 分页用Dto
	 */
	public void setPagingDto(PagingDto pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 执行分页
	 * 
	 * @param recordSum 记录总数
	 * @throws Exception 抛出默认异常
	 */
	public void executePaging(int recordSum) throws Exception {
		logger.debug("The begin of the method SJFPagingActionSupport.executePaging");

		try {
			// 每页显示多少行从数据库中字典项获取
			DictItem sysDictItem = this.dictItemService.getDictItemByItemCode(DictConstant.DICT_ITEM_PAGESIZE);
			int pageSize = Integer.parseInt(sysDictItem.getDictItemValue());

			// 初始执行Action时分页对象需要实例化
			if (pagingDto == null) {
				pagingDto = new PagingDto();
			}

			// 设置分页对象的相关属性值
			pagingDto.setPageSize(pageSize);
			pagingDto.setRecordSum(recordSum);
			pagingDto.setPageSum(this.getPageSum());
			pagingDto.setStart((pagingDto.getCurrentPage() - 1) * pageSize);
			pagingDto.setEnd(pagingDto.getStart() + pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
		}
		logger.debug("The begin of the method SJFPagingActionSupport.executePaging");
	}

	/**
	 * 计算出分页总数
	 * 
	 * @return 分页总数
	 */
	private int getPageSum() {
		logger.debug("The begin of the method SJFPagingActionSupport.getPageSum");
		
		int pageSum = pagingDto.getRecordSum() / pagingDto.getPageSize();
		if (pagingDto.getRecordSum() % pagingDto.getPageSize() > 0) {
			pageSum++;
		}
		
		logger.debug("The begin of the method SJFPagingActionSupport.getPageSum");
		
		return pageSum;
	}
}
