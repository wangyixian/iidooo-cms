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
                addActionError(getText("MSG_UPDATE_FAILED"));
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

    public void validateUpdate() {
        try {
            // 更新的对象不存在
            if (channel == null || ValidateUtil.isEmpty(channel.getChannelID())) {
                addActionError(getText("MSG_OBJECT_NOT_EXIST"));
            }

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

            // 自己不能做自己的父节点
            if (channel.getParentID() == channel.getChannelID()) {
                addActionError(getText("MSG_PARENT_SELF_EXCEPTION"));
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

    public String delete() {
        try {
            if (!channelDetailService.deleteChannel(this.channel)) {
                addActionError(getText("MSG_DELETE_FAILED"));
                return INPUT;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateDelete() {
        try {
            // 更新的对象不存在
            if (channel == null || ValidateUtil.isEmpty(channel.getChannelID())) {
                addActionError(getText("MSG_OBJECT_NOT_EXIST"));
            }

            // 存在子无法删除
            if (channelDetailService.hasChildren(channel.getChannelID())) {
                addActionError(getText("MSG_DELETE_FAILED_CHILDREN"));
            }

            if (this.getActionErrors().size() > 0) {
                // 构建栏目树
                root = ChannelUtil.constructChannelTree();
                root.setName(this.getText(root.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
