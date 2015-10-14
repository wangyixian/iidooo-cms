package com.iidooo.cms.api.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.IContentProductService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.core.action.common.BaseAPIAction;
import com.iidooo.core.constant.ClassConstant;
import com.iidooo.core.constant.DBConstant;
import com.iidooo.core.constant.HttpConstant;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.JsonUtil;
import com.iidooo.core.util.PageUtil;
import com.iidooo.core.util.ValidateUtil;

public class ContentProductAction extends BaseAPIAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentProductAction.class);

    @Autowired
    private IContentProductService contentProductService;

    public void product() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case HttpConstant.METHOD_GET:
                String contentID = this.getRequestParameter(CmsConstant.FIELD_CONTENT_ID);

                if (contentID == null || contentID.isEmpty()) {
                    return;
                }

                ContentProductDto contentProduct = contentProductService.getContentProduct(Integer.parseInt(contentID));

                JsonUtil.responseObject(contentProduct, this.getResponse());
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void products() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case HttpConstant.METHOD_GET:
                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);
                String channelPath = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_PATH);
                String pageStart = this.getRequestParameter(ClassConstant.FIELD_PAGE_START);
                String pageSize = this.getRequestParameter(ClassConstant.FIELD_PAGE_SIZE);
                String sortField = this.getRequestParameter(ClassConstant.FIELD_PAGE_SORT_FIELD);
                String sortType = this.getRequestParameter(ClassConstant.FIELD_PAGE_SORT_TYPE);
                String currentPage = this.getRequestParameter(ClassConstant.FIELD_PAGE_CURRENT_PAGE);

                // The required item
                if (siteCode == null || siteCode.isEmpty() || channelPath == null || channelPath.isEmpty()) {
                    return;
                }

                // The option item set the default value.
                if (ValidateUtil.isEmpty(pageStart)) {
                    pageStart = "0";
                }
                if (ValidateUtil.isEmpty(pageSize)) {
                    pageSize = "10";
                }
                if (ValidateUtil.isEmpty(sortField)) {
                    sortField = DBConstant.FIELD_UPDATETIME;
                }
                if (ValidateUtil.isEmpty(sortType)) {
                    sortType = DBConstant.SORT_TYPE_DESC;
                }
                if (ValidateUtil.isEmpty(currentPage)) {
                    currentPage = "1";
                }

                PageDto page = new PageDto();
                page.setStart(Integer.parseInt(pageStart));
                page.setPageSize(Integer.parseInt(pageSize));
                page.setSortField(sortField);
                page.setSortType(sortType);
                page.setCurrentPage(Integer.parseInt(currentPage));

                // Construct the ContentProductDto as the search condition.
                String productCountry = this.getRequestParameter(CmsConstant.FIELD_CONTENT_PRODUCT_COUNTRY);
                String productOrigin = this.getRequestParameter(CmsConstant.FIELD_CONTENT_PRODUCT_ORIGIN);
                ContentProductDto product = new ContentProductDto();
                product.setProductCountry(productCountry);
                product.setProductOrigin(productOrigin);
                product.setChannelPath(channelPath);

                int count = contentProductService.searchContentProductListSize(siteCode, product);

                PageUtil pageUtil = new PageUtil(this.getServletContext());
                this.setPage(pageUtil.executePage(count, page));

                List<ContentProductDto> productList = contentProductService.searchContentProductList(siteCode, product, this.getPage());

                JsonUtil.responseObjectArray(productList, this.getPage(), this.getResponse());
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
