package com.iidooo.framework.action;

import org.apache.log4j.Logger;

import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.dto.base.PagingDto;


/**
 * The support action of doing page split
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
	 * The paging dto
	 */
	private PagingDto pagingDto;

	public PagingDto getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDto pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * Execute paging
	 * 
	 * @param recordSum The record sum
	 * @throws Exception The default exception will be thrown.
	 */
	public void executePaging(int recordSum) throws Exception {
		try {
			// Read the defined page size
		    int pageSize = (int)this.getApplicationValue(DictConstant.DICT_ITEM_PAGE_SIZE);

			if (pagingDto == null) {
				pagingDto = new PagingDto();
			}

			// Set paging dto fields.
			pagingDto.setPageSize(pageSize);
			pagingDto.setRecordSum(recordSum);
			pagingDto.setPageSum(this.getPageSum());
			pagingDto.setStart((pagingDto.getCurrentPage() - 1) * pageSize);
			pagingDto.setEnd(pagingDto.getStart() + pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.toString());
			throw e;
		}
	}
	
	public void executePaging(int recordSum, int pageSize) throws Exception {
        try {
            if (pagingDto == null) {
                pagingDto = new PagingDto();
            }
            // Set paging dto fields.
            pagingDto.setPageSize(pageSize);
            pagingDto.setRecordSum(recordSum);
            pagingDto.setPageSum(this.getPageSum());
            pagingDto.setStart((pagingDto.getCurrentPage() - 1) * pageSize);
            pagingDto.setEnd(pagingDto.getStart() + pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.toString());
            throw e;
        }
    }

	/**
	 * Calculate the page sum
	 * 
	 * @return The page sum
	 */
	private int getPageSum() {		
		int pageSum = pagingDto.getRecordSum() / pagingDto.getPageSize();
		if (pagingDto.getRecordSum() % pagingDto.getPageSize() > 0) {
			pageSum++;
		}		
		return pageSum;
	}
}
