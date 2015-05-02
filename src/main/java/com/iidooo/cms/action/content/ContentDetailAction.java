package com.iidooo.cms.action.content;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.content.IContentDetailService;
import com.opensymphony.xwork2.ActionSupport;

public class ContentDetailAction extends ActionSupport {

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
                contentInfoService.createContent(content);
                break;
            case CmsConstant.CONTENT_TYPE_PRODUCT:
                contentInfoService.createContent(content, product);
                break;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateCreate() {
        try {
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
