package com.iidooo.cms.action.channel;

import org.apache.log4j.Logger;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.ChannelDetailService;
import com.iidooo.cms.service.channel.impl.ChannelDetailServiceImpl;
import com.iidooo.cms.util.ChannelUtil;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.tag.entity.TreeNode;
import com.iidooo.core.util.ValidateUtil;

public class ChannelDetailAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelDetailAction.class);

    private ChannelDetailService channelDetailService;

    /**
     * 创建栏目树所用的根节点
     */
    private TreeNode root;

    private ChannelDto channel;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public ChannelDetailAction() {
        channelDetailService = new ChannelDetailServiceImpl();
    }

    public String init() {
        try {
            if (channel != null && channel.getChannelID() != null && channel.getChannelID() > 0) {
                channel = channelDetailService.getChannelByID(channel.getChannelID());
            }

            // 构建栏目树
            root = ChannelUtil.constructChannelTree();
            root.setName(this.getText(root.getName()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String create() {
        try {
            if (!channelDetailService.createChannel(channel)) {
                addActionError(getText("MSG_CREATE_FAILED"));
                
                // 构建栏目树
                root = ChannelUtil.constructChannelTree();
                root.setName(this.getText(root.getName()));
                
                return INPUT;
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
            // 栏目名称不能为空
            if (ValidateUtil.isEmpty(channel.getChannelName())) {
                addActionError(getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_CHANNEL_NAME") }));
            }

            // 栏目路径不能为空
            if (ValidateUtil.isEmpty(channel.getChannelPath())) {
                addActionError(getText("MSG_FIELD_REQUIRED", new String[] { getText("LABEL_CHANNEL_PATH") }));
            }

            // 栏目路径必须是英文格式
            if (!ValidateUtil.isEnglish(channel.getChannelPath())) {
                addActionError(getText("MSG_FIELD_ENGLISH_REQUIRED", new String[] { getText("LABEL_CHANNEL_PATH") }));
            }

            // 判断该栏目路径是否存在
            ChannelDto existChannel = channelDetailService.getChannelByPath(channel.getChannelPath());
            if (existChannel != null) {
                addActionError(getText("MSG_FIELD_DUPLICATE", new String[] { channel.getChannelPath() }));
            }

            if (this.getActionErrors().size() > 0) {
                // 构建栏目树
                root = ChannelUtil.constructChannelTree();
                root.setName(this.getText(root.getName()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }

    public String update() {
        try {
            if (!channelDetailService.updateChannel(channel)) {
                addActionError(getText("MSG_CHANNEL_UPDATE_FAILED", new String[] { channel.getChannelName() }));
                return INPUT;
            }
            addActionMessage(getText("MSG_CHANNEL_UPDATE_SUCCESS", new String[] { channel.getChannelName() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateUpdate() {
        try {
            if (channel == null || ValidateUtil.isEmpty(channel.getChannelID())) {
                addActionError(getText("MSG_CHANNEL_ID_REQUIRE"));
            }

            if (ValidateUtil.isEmpty(channel.getChannelName())) {
                addActionError(getText("MSG_CHANNEL_NAME_REQUIRE"));
            }

            if (ValidateUtil.isEmpty(channel.getChannelPath())) {
                addActionError(getText("MSG_CHANNEL_PATH_REQUIRE"));
            }

            // The channel path must be English
            if (!ValidateUtil.isEnglish(channel.getChannelPath())) {
                addActionError(getText("MSG_CHANNEL_PATH_ENGLISH"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }
}
