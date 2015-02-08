package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.impl.ChannelListServiceImpl;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.tag.TreeNode;
import com.iidooo.framework.utility.StringUtil;

@Service
public class ChannelServiceImpl implements ChannelService {

    private static final Logger logger = Logger.getLogger(ChannelListServiceImpl.class);

    @Autowired
    private CmsChannelDao cmsChannelDao;

    @Override
    public TreeNode getRootTree(String rootName, String baseURL) {
        try {
            TreeNode rootTreeNode = new TreeNode();
            rootTreeNode.setUrl(StringUtil.replace(baseURL, "0"));
            rootTreeNode.setName(rootName);

            List<CmsChannelDto> allChannels = this.getAllChannels();

            Map<Integer, TreeNode> channelMap = new HashMap<Integer, TreeNode>();
            for (CmsChannelDto channel : allChannels) {
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
            for (CmsChannelDto channel : allChannels) {
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

            List<CmsChannelDto> allChannels = this.getAllChannels();

            Map<Integer, TreeNode> channelMap = new HashMap<Integer, TreeNode>();
            for (CmsChannelDto channel : allChannels) {
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
            for (CmsChannelDto channel : allChannels) {
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
    public List<CmsChannelDto> getAllChannels() {
        try {
            List<CmsChannelDto> channelList = null;
            channelList = cmsChannelDao.selectAll();
            return channelList;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public List<CmsChannelDto> getOffspringChannels(int parentID, boolean containSelf) {
        try {
            List<CmsChannelDto> offspringChannels = new ArrayList<CmsChannelDto>();

            List<CmsChannelDto> allChannels = cmsChannelDao.selectAll();

            if (parentID <= 0) {
                offspringChannels = allChannels;
            } else {
                CmsChannelDto rootChannelDto = null;
                Map<Integer, CmsChannelDto> channelMap = new HashMap<Integer, CmsChannelDto>();
                for (CmsChannelDto channel : allChannels) {
                    channelMap.put(channel.getChannelID(), channel);
                    if (channel.getChannelID() == parentID) {
                        rootChannelDto = channel;
                    }
                }

                for (CmsChannelDto channel : allChannels) {
                    if (channel.getParentID() > 0) {
                        CmsChannelDto parent = channelMap.get(channel.getParentID());
                        parent.getChildren().add(channel);
                    }
                }

                // If contain self flag is true, add the root channel into the return list.
                if (containSelf) {
                    offspringChannels.add(rootChannelDto);
                }

                List<CmsChannelDto> children = rootChannelDto.getChildren();
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
    public CmsChannelDto getChannelByID(int channelID) {
        try {
            CmsChannelDto result = cmsChannelDao.selectChannelByID(channelID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public CmsChannelDto getChannelByPath(String channelPath) {
        try {
            CmsChannelDto result = cmsChannelDao.selectChannelByPath(channelPath);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    private void getChildrenChannelIDs(List<CmsChannelDto> children, List<CmsChannelDto> offspringChannels) {
        try {
            for (CmsChannelDto channel : children) {
                offspringChannels.add(channel);
                this.getChildrenChannelIDs(channel.getChildren(), offspringChannels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
