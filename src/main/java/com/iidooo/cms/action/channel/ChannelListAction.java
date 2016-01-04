package com.iidooo.cms.action.channel;

import java.util.List;

import org.apache.log4j.Logger;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.ChannelListService;
import com.iidooo.cms.service.channel.impl.ChannelListServiceImpl;
import com.iidooo.cms.util.ChannelUtil;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.tag.entity.TreeNode;
import com.iidooo.core.util.ValidateUtil;

public class ChannelListAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    /**
     * 处理栏目一览页面的service
     */
    private ChannelListService channelListService;

    /**
     * 创建栏目树所用的根节点
     */
    private TreeNode root;

    private List<ChannelDto> channelList;

    private ChannelDto channel;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public List<ChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelDto> channelList) {
        this.channelList = channelList;
    }

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public ChannelListAction() {
        this.channelListService = new ChannelListServiceImpl();
    }

    public String init() {
        try {
            if (channel == null) {
                // 页面初始化时该参数为空
                channel = new ChannelDto();
                channel.setParentID(0);
            }

            // 根据ParentID获取栏目一览
            channelList = channelListService.getChildrenChannelList(channel.getParentID());

            root = ChannelUtil.constructChannelTree();
            root.setName(this.getText(root.getName()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String delete() {
        try {
            if (!channelListService.deleteChannel(this.channel)) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED", new String[] { channel.getChannelName() }));
                return INPUT;
            }

            addActionMessage(getText("MSG_CHANNEL_DELETE_SUCCESS", new String[] { channel.getChannelName() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateDelete() {
        try {
            if (channel == null || ValidateUtil.isEmpty(channel.getChannelID())) {
                addActionError(getText("MSG_CHANNEL_ID_REQUIRE"));
            }

            if (channelListService.hasChildren(channel.getChannelID())) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED_CHILDREN", new String[] { channel.getChannelName() }));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
