package com.iidooo.cms.client.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.service.AttachAlbumService;
import com.iidooo.cms.client.service.ChannelService;
import com.iidooo.cms.client.service.ContentService;
import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.CmsAttachAlbumDto;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;

public class AttachAlbumAction extends CmsBaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(AttachAlbumAction.class);

    @Autowired
    private AttachAlbumService attachAlbumService;
    
    @Autowired
    private ChannelService channelService;
    
    @Autowired
    private ContentService contentService;

    private CmsChannelDto currentChannel;

    private CmsContentDto currentContent;

    private CmsAttachAlbumDto currentAlbum;

    public CmsChannelDto getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(CmsChannelDto currentChannel) {
        this.currentChannel = currentChannel;
    }

    public CmsContentDto getCurrentContent() {
        return currentContent;
    }

    public void setCurrentContent(CmsContentDto currentContent) {
        this.currentContent = currentContent;
    }

    public CmsAttachAlbumDto getCurrentAlbum() {
        return currentAlbum;
    }

    public void setCurrentAlbum(CmsAttachAlbumDto currentAlbum) {
        this.currentAlbum = currentAlbum;
    }

    @Override
    public String execute() throws Exception {
        try {
            HttpServletRequest request = this.getRequest();
            String albumID = request.getParameter(AttributeConstant.ATTACH_ALBUM_ID);
            if (albumID == null || albumID == "") {
                return NONE;
            }
            this.currentAlbum = attachAlbumService.getAttachAlbumDto(Integer.parseInt(albumID));
            if (this.currentAlbum == null) {
                return NONE;
            }
            
            this.currentContent = contentService.getContentByID(this.currentAlbum.getContentID());
            this.currentChannel = channelService.getChannelByID(this.currentContent.getChannelID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
