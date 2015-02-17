package com.iidooo.framework.dto.base;

/**
 * 
 * 
 * @author wangyixian
 * 
 */
public class PagingDto {

	 /**
     * 默认构造函数
     */
    public PagingDto() {
        // 当前页默认值为1
        currentPage = 1;
    }

    /**
     * 检索开始行号
     */
    private int start;

    /**
     * 检索结束行号
     */
    private int end;

    /**
     * 每页显示行总数
     */
    private int pageSize;

    /**
     * 当前页号
     */
    private int currentPage;

    /**
     * 检索出的记录总数
     */
    private int recordSum;

    /**
     * 总页数
     */
    private int pageSum;

    /**
     * 得到检索开始行号
     * 
     * @return start
     */
    public final int getStart() {
        return start;
    }

    /**
     * 设置检索开始行号
     * 
     * @param start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 得到检索结束行号
     * 
     * @return end
     */
    public int getEnd() {
        return end;
    }

    /**
     * 设置检索结束行号
     * 
     * @param end
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * 得到每页显示行总数
     * 
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页显示行总数
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 得到当前页号
     * 
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置当前页号
     * 
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 得到检索出的记录总数
     * 
     * @return recordSum
     */
    public int getRecordSum() {
        return recordSum;
    }

    /**
     * 设置检索出的记录总数
     * 
     * @param recordSum
     */
    public void setRecordSum(int recordSum) {
        this.recordSum = recordSum;
    }

    /**
     * 得到总页数
     * 
     * @return
     */
    public int getPageSum() {
        return pageSum;
    }

    /**
     * 设置总页数
     * 
     * @param pageSum
     */
    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }
}
