package com.iidooo.cms.action.content;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.content.IContentDetailService;
import com.iidooo.core.action.BaseAction;

public class ContentDetailAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentDetailAction.class);

    @Autowired
    private IContentDetailService contentInfoService;

    private ContentDto content;

    private ContentProductDto product;

    public ContentDto getContent() {
        return content;
    }

    public void setContent(ContentDto content) {
        this.content = content;
    }

    public ContentProductDto getProduct() {
        return product;
    }

    public void setProduct(ContentProductDto product) {
        this.product = product;
    }

    public String init() {
        try {
            if (content.getContentID() != null) {
                content = contentInfoService.getContentByID(content);
                if (content == null) {
                    addActionMessage(getText("MSG_CONTENT_NOT_EXIST", content.getContentID().toString()));
                    return INPUT;
                }

                if (content.getContentType().equals(CmsConstant.CONTENT_TYPE_PRODUCT)) {
                    product = (ContentProductDto) content;
                }
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String create() {
        try {
            switch (content.getContentType()) {
            case CmsConstant.CONTENT_TYPE_DEFAULT:
                if(!contentInfoService.createContent(content)){
                    addActionError(getText("MSG_CONTENT_CREATE_FAILED"));
                    return INPUT;
                }
                break;
            case CmsConstant.CONTENT_TYPE_PRODUCT:
                if(!contentInfoService.createContent(content, product)){
                    addActionError(getText("MSG_CONTENT_CREATE_FAILED"));
                    return INPUT;
                }
                break;
            }
            addActionMessage(getText("MSG_CONTENT_CREATE_SUCCESS", content.getContentTitle()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateCreate() {
        try {
            if (content.getContentType().isEmpty()) {
                addActionError(getText("MSG_CONTENT_TYPE_REQUIRE"));
            }
            if (content.getChannelID() == null || content.getChannelID() <= 0) {
                addActionError(getText("MSG_CONTENT_CHANNEL_REQUIRE"));
            }
            if (content.getContentTitle().isEmpty()) {
                addActionError(getText("MSG_CONTENT_TITLE_REQUIRE"));
            }
            if (content.getContentType().equals(CmsConstant.CONTENT_TYPE_PRODUCT)) {
                if (product.getProductCountry().isEmpty()) {
                    addActionError(getText("MSG_CONTENT_PRODUCT_COUNTRY_REQUIRE"));
                }
                if (product.getProductOrigin().isEmpty()) {
                    addActionError(getText("MSG_CONTENT_PRODUCT_ORIGINAL_REQUIRE"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }

    public String update() {
        try {

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateUpdate() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }
}
