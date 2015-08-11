package com.iidooo.cms.action.content;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.content.ContentDetailService;
import com.iidooo.core.util.ValidateUtil;

public class ContentDetailAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentDetailAction.class);

    @Autowired
    private ContentDetailService contentInfoService;

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
            if (content != null && content.getContentID() != null) {
                int siteID = content.getSiteID();
                content = contentInfoService.getContentByID(content.getContentID());
                if (content == null) {
                    addActionMessage(getText("MSG_CONTENT_NOT_EXIST", new String[] { content.getContentID().toString() }));
                    return INPUT;
                }
                content.setSiteID(siteID);

                if (content.getContentType().equals(CmsConstant.DICT_ITEM_CONTENT_TYPE_PRODUCT)) {
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
            content.setChannelID(content.getNewChannelID());
            switch (content.getContentType()) {
            case CmsConstant.DICT_ITEM_CONTENT_TYPE_DEFAULT:
                if (!contentInfoService.createContent(content)) {
                    addActionError(getText("MSG_CONTENT_CREATE_FAILED"));
                    return INPUT;
                }
                break;
            case CmsConstant.DICT_ITEM_CONTENT_TYPE_PRODUCT:
                if (!contentInfoService.createContent(content, product)) {
                    addActionError(getText("MSG_CONTENT_CREATE_FAILED"));
                    return INPUT;
                }
                break;
            }
            addActionMessage(getText("MSG_CONTENT_CREATE_SUCCESS", new String[] { content.getContentTitle() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateCreate() {
        try {
            if (ValidateUtil.isEmpty(content.getContentType())) {
                addActionError(getText("MSG_CONTENT_TYPE_REQUIRE"));
            }
            if (ValidateUtil.isEmpty(content.getNewChannelID()) || content.getNewChannelID() <= 0) {
                addActionError(getText("MSG_CONTENT_CHANNEL_REQUIRE"));
            }
            if (ValidateUtil.isEmpty(content.getContentTitle())) {
                addActionError(getText("MSG_CONTENT_TITLE_REQUIRE"));
            }

            if (content.getContentType().equals(CmsConstant.DICT_ITEM_CONTENT_TYPE_PRODUCT)) {
                if (ValidateUtil.isEmpty(product.getProductCountry())) {
                    addActionError(getText("MSG_CONTENT_PRODUCT_COUNTRY_REQUIRE"));
                }
                if (ValidateUtil.isEmpty(product.getProductOrigin())) {
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
            // When change the content's channel, the new channel ID will accept the value.
            // Set it to the content.channelID for update.
            if (content.getChannelID() != content.getNewChannelID()) {
                content.setChannelID(content.getNewChannelID());
            }
            switch (content.getContentType()) {
            case CmsConstant.DICT_ITEM_CONTENT_TYPE_DEFAULT:
                if (!contentInfoService.updateContent(content)) {
                    addActionError(getText("MSG_CONTENT_UPDATE_FAILED", new String[] { content.getContentTitle() }));
                    return INPUT;
                }
                break;
            case CmsConstant.DICT_ITEM_CONTENT_TYPE_PRODUCT:
                if (!contentInfoService.updateContent(content, product)) {
                    addActionError(getText("MSG_CONTENT_UPDATE_FAILED", new String[] { content.getContentTitle() }));
                    return INPUT;
                }
                break;
            }

            addActionMessage(getText("MSG_CONTENT_UPDATE_SUCCESS", new String[] { content.getContentTitle() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateUpdate() {
        try {
            if (ValidateUtil.isEmpty(content.getContentType())) {
                addActionError(getText("MSG_CONTENT_TYPE_REQUIRE"));
            }
            if (ValidateUtil.isEmpty(content.getNewChannelID()) || content.getNewChannelID() <= 0) {
                addActionError(getText("MSG_CONTENT_CHANNEL_REQUIRE"));
            }
            if (ValidateUtil.isEmpty(content.getContentTitle())) {
                addActionError(getText("MSG_CONTENT_TITLE_REQUIRE"));
            }
            if (content.getContentType().equals(CmsConstant.DICT_ITEM_CONTENT_TYPE_PRODUCT)) {
                if (ValidateUtil.isEmpty(product.getProductCountry())) {
                    addActionError(getText("MSG_CONTENT_PRODUCT_COUNTRY_REQUIRE"));
                }
                if (ValidateUtil.isEmpty(product.getProductOrigin())) {
                    addActionError(getText("MSG_CONTENT_PRODUCT_ORIGINAL_REQUIRE"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }
}
