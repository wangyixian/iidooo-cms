package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.framework.exception.ExclusiveException;
import com.iidooo.framework.tag.component.TreeNode;
import com.iidooo.framework.utility.StringUtil;

@Service
public class ChannelServiceImpl implements IChannelService {

    private static final Logger logger = Logger.getLogger(ChannelServiceImpl.class);

    @Autowired
    private ChannelDao cmsChannelDao;

    @Override
    public TreeNode getRootTree(String rootName, String baseURL) {
        try {
            TreeNode rootTreeNode = new TreeNode();
            rootTreeNode.setUrl(StringUtil.replace(baseURL, "0"));
            rootTreeNode.setName(rootName);

            List<ChannelDto> allChannels = this.getAllChannels();

            Map<Integer, TreeNode> channelMap = new HashMap<Integer, TreeNode>();
            for (ChannelDto channel : allChannels) {
                // Build the tree node of the CmsChannelDto
                TreeNode treeNode = new TreeNode();
                treeNode.setUrl(StringUtil.replace(baseURL, channel.getChannelID().toString()));
                treeNode.setName(channel.getChannelName());
                treeNode.setTag(channel);

                // Set the root tree node as the parent tree node, if the parent ID is 0.
                if (channel.getParentID() == 0) {
                    treeNode.setParent(rootTreeNode);
                }

                channelMap.put(channel.getChannelID(), treeNode);
            }

            // Set the tree node's parent
            for (ChannelDto channel : allChannels) {
                if (channel.getParentID() != 0) {
                    TreeNode treeNode = channelMap.get(channel.getChannelID());
                    TreeNode parent = channelMap.get(channel.getParentID());
                    treeNode.setParent(parent);
                }
            }
            return rootTreeNode;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public TreeNode getRootTree(String rootName, String baseURLList, String baseURLDetail) {
        try {
            TreeNode rootTreeNode = new TreeNode();
            rootTreeNode.setUrl(StringUtil.replace(baseURLList, "0"));
            rootTreeNode.setName(rootName);

            List<ChannelDto> allChannels = this.getAllChannels();

            Map<Integer, TreeNode> channelMap = new HashMap<Integer, TreeNode>();
            for (ChannelDto channel : allChannels) {
                // Build the tree node of the CmsChannelDto
                TreeNode treeNode = new TreeNode();
                treeNode.setUrl(StringUtil.replace(baseURLDetail, channel.getChannelID().toString()));
                treeNode.setName(channel.getChannelName());
                treeNode.setTag(channel);

                // Set the root tree node as the parent tree node, if the parent ID is 0.
                if (channel.getParentID() == 0) {
                    treeNode.setParent(rootTreeNode);
                }

                channelMap.put(channel.getChannelID(), treeNode);
            }

            // Set the tree node's parent
            for (ChannelDto channel : allChannels) {
                if (channel.getParentID() != 0) {
                    TreeNode treeNode = channelMap.get(channel.getChannelID());
                    TreeNode parent = channelMap.get(channel.getParentID());
                    parent.setUrl(StringUtil.replace(baseURLList, channel.getParentID().toString()));
                    treeNode.setParent(parent);
                }
            }
            return rootTreeNode;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
    
    @Override
    public List<ChannelDto> getOffspringChannels(int parentID, boolean containSelf) {
        try {
            List<ChannelDto> offspringChannels = new ArrayList<ChannelDto>();

            List<ChannelDto> allChannels = cmsChannelDao.selectAll();

            if (parentID <= 0) {
                offspringChannels = allChannels;
            } else {
                ChannelDto rootChannelDto = null;
                Map<Integer, ChannelDto> channelMap = new HashMap<Integer, ChannelDto>();
                for (ChannelDto channel : allChannels) {
                    channelMap.put(channel.getChannelID(), channel);
                    if (channel.getChannelID() == parentID) {
                        rootChannelDto = channel;
                    }
                }

                for (ChannelDto channel : allChannels) {
                    if (channel.getParentID() > 0) {
                        ChannelDto parent = channelMap.get(channel.getParentID());
                        parent.getChildren().add(channel);
                    }
                }

                // If contain self flag is true, add the root channel into the return list.
                if (containSelf) {
                    offspringChannels.add(rootChannelDto);
                }

                List<ChannelDto> children = rootChannelDto.getChildren();
                this.getChildrenChannelIDs(children, offspringChannels);
            }

            return offspringChannels;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }


    
    

    @Override
    public List<ChannelDto> getChildrenChannels(int parentID) {
        try {
            List<ChannelDto> channels = cmsChannelDao.selectByParentID(parentID);
            return channels;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public ChannelDto getChannelByPath(String channelPath) {
        try {
            ChannelDto result = cmsChannelDao.selectChannelByPath(channelPath);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    private void getChildrenChannelIDs(List<ChannelDto> children, List<ChannelDto> offspringChannels) {
        try {
            for (ChannelDto channel : children) {
                offspringChannels.add(channel);
                this.getChildrenChannelIDs(channel.getChildren(), offspringChannels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
    


    @Override
    public ChannelDto exclusiveCheck(int channelID, int version) {
        try {
            ChannelDto channel = cmsChannelDao.exclusiveCheck(channelID, version);
            return channel;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
    
    
}
