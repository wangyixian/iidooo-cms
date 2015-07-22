package com.iidooo.core.util;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.dto.extend.DictItemDto;

public class PageUtil {
    private static final Logger logger = Logger.getLogger(PageUtil.class);

    private ServletContext sc;

    public PageUtil(ServletContext sc) {
        this.sc = sc;
    }

    /**
     * Execute the page action.
     * 
     * @param count The record count of data
     * @param page The input page object
     * @return The new page object
     */
    public PageDto executePage(int count, PageDto page) {
        PageDto result = new PageDto();
        try {

            if (page == null) {
                page = new PageDto(); 
                
                // Set the page default size
                Map<String, DictItemDto> pageDictItemMap = (Map<String, DictItemDto>) sc.getAttribute(CoreConstants.DICT_CLASS_CORE_PAGE);
                DictItemDto pageSize = pageDictItemMap.get(CoreConstants.DICT_ITEM_PAGE_SIZE);
                page.setPageSize(Integer.parseInt(pageSize.getDictItemValue()));
            } else {
                result.setSortField(page.getSortField());
                result.setSortType(page.getSortType());
                result.setCurrentPage(page.getCurrentPage());
            }

            // Set paging dto fields.
            result.setPageSize(page.getPageSize());
            result.setRecordSum(count);

            int pageSum = count / page.getPageSize();
            if (count % page.getPageSize() > 0) {
                pageSum++;
            }
            result.setPageSum(pageSum);

            result.setStart((page.getCurrentPage() - 1) * result.getPageSize());
            result.setEnd(result.getStart() + result.getPageSize());

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.toString());
        }
        return result;
    }
}
