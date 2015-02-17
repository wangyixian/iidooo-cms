package com.iidooo.cms.client.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.directive.AttachListDirective;
import com.iidooo.cms.client.directive.ChannelListDirective;
import com.iidooo.cms.client.directive.ContentListDirective;
import com.iidooo.cms.client.directive.StatisticsDirective;
import com.iidooo.cms.dto.generate.CmsChannel;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.action.BaseAction;
import com.iidooo.framework.action.PagingActionSupport;

public abstract class CmsBaseAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // Regist the freemarker directives

    @Autowired
    private ContentListDirective directiveContentList;

    @Autowired
    private ChannelListDirective directiveChannelList;

    @Autowired
    private StatisticsDirective directiveStatistics;

    @Autowired
    private AttachListDirective directiveAttachList;

    public ContentListDirective getDirectiveContentList() {
        return directiveContentList;
    }

    public void setDirectiveContentList(ContentListDirective directiveContentList) {
        this.directiveContentList = directiveContentList;
    }

    public ChannelListDirective getDirectiveChannelList() {
        return directiveChannelList;
    }

    public void setDirectiveChannelList(ChannelListDirective directiveChannelList) {
        this.directiveChannelList = directiveChannelList;
    }

    public StatisticsDirective getDirectiveStatistics() {
        return directiveStatistics;
    }

    public void setDirectiveStatistics(StatisticsDirective directiveStatistics) {
        this.directiveStatistics = directiveStatistics;
    }

    public AttachListDirective getDirectiveAttachList() {
        return directiveAttachList;
    }

    public void setDirectiveAttachList(AttachListDirective directiveAttachList) {
        this.directiveAttachList = directiveAttachList;
    }

    // End Regist

    
    
}
