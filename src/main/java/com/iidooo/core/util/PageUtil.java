package com.iidooo.core.util;

import org.apache.log4j.Logger;

import com.iidooo.core.dto.PageDto;

public class PageUtil {
    private static final Logger logger = Logger.getLogger(PageUtil.class);
    
    /**
     * Execute the page action.
     * 
     * @param count The record count of data
     * @param page The input page object
     * @return The new page object
     */
    public static PageDto executePage(int count, PageDto page) {
        PageDto result = new PageDto();
        try {

            if (page == null) {
                page = new PageDto();
            } else {
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
