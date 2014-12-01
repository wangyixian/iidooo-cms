package com.iidooo.cms.action.client;

import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.freemarker.directive.AttachAlbumList;
import com.iidooo.cms.freemarker.directive.ChannelList;
import com.iidooo.cms.freemarker.directive.ContentList;
import com.iidooo.cms.freemarker.directive.Statistics;
import com.iidooo.framework.action.BaseAction;

public abstract class CmsBaseAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // Regist the freemarker directives

    @Autowired
    private ContentList contentList;

    @Autowired
    private ChannelList channelList;

    @Autowired
    private Statistics statistics;
    
    @Autowired
    private AttachAlbumList attachAlbumList;

    public ContentList getContentList() {
        return contentList;
    }

    public ChannelList getChannelList() {
        return channelList;
    }

    public Statistics getStatistics() {
        return statistics;
    }
    
    public AttachAlbumList getAttachAlbumList(){
        return attachAlbumList;
    }

    // End Regist

}
