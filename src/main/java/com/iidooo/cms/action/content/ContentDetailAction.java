package com.iidooo.cms.action.content;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.ContentDetailService;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.ValidateUtil;

public class ContentDetailAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentDetailAction.class);

    private ContentDetailService contentInfoService;

    private ContentDto content;

    public ContentDto getContent() {
        return content;
    }

    public void setContent(ContentDto content) {
        this.content = content;
    }

    public String init() {
        try {
            if (content != null && content.getContentID() != null) {
                content = contentInfoService.getContentByID(content.getContentID());
                if (content == null) {
                    addActionMessage(getText("MSG_CONTENT_NOT_EXIST", new String[] { content.getContentID().toString() }));
                    return INPUT;
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
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }
}
