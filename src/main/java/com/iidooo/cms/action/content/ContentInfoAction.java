package com.iidooo.cms.action.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.channel.ChannelListAction;
import com.iidooo.cms.admin.service.ContentDetailService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.cms.service.ContentArticleService;
import com.iidooo.cms.service.ContentProductService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.action.BaseAction;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.tag.component.TreeNode;

public class ContentInfoAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private IChannelService channelService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentArticleService contentArticleService;

    @Autowired
    private ContentProductService contentProductService;

    @Autowired
    private ContentDetailService contentDetailService;

    // 1: Create
    // 2: Update
    // 3: Copy
    // 4: Delete
    private int mode = 1;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    // The channel tree's root node
    private TreeNode rootTreeNode;

    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }

    public void setRootTreeNode(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }

    private ContentDto content;

    public ContentDto getContent() {
        return content;
    }

    public void setContent(ContentDto content) {
        this.content = content;
    }

    private List<ChannelDto> allChannels;

    public List<ChannelDto> getAllChannels() {
        return allChannels;
    }

    public void setAllChannels(List<ChannelDto> allChannels) {
        this.allChannels = allChannels;
    }

    // Article Content
    private CmsContentArticleDto article;

    private List<DictItemDto> articleTypes;

    public CmsContentArticleDto getArticle() {
        return article;
    }

    public void setArticle(CmsContentArticleDto article) {
        this.article = article;
    }

    public List<DictItemDto> getArticleTypes() {
        return articleTypes;
    }

    public void setArticleTypes(List<DictItemDto> articleTypes) {
        this.articleTypes = articleTypes;
    }

    // Product
    private List<DictItemDto> productTypes;

    public List<DictItemDto> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<DictItemDto> productTypes) {
        this.productTypes = productTypes;
    }

    private List<DictItemDto> productCountries;

    public List<DictItemDto> getProductCountries() {
        return productCountries;
    }

    public void setProductCountries(List<DictItemDto> productCountries) {
        this.productCountries = productCountries;
    }

    private List<DictItemDto> productOrigins;

    public List<DictItemDto> getProductOrigins() {
        return productOrigins;
    }

    public void setProductOrigins(List<DictItemDto> productOrigins) {
        this.productOrigins = productOrigins;
    }

    private ContentProductDto product;

    public ContentProductDto getProduct() {
        return product;
    }

    public void setProduct(ContentProductDto product) {
        this.product = product;
    }

    public String init() {
        try {
           
            rootTreeNode = channelService.getRootTree(getText("LABEL_TREE_ROOT"), CmsConstant.CONTENT_LIST_INIT);
            allChannels = channelService.getAllChannels();
            
            // The modify or copy mode
            if (mode == 2 || mode == 3) {
                content = contentService.getContentByID(content.getContentID());
                switch (content.getContentType()) {
                case "2":
                    product = contentProductService.getContentByID(content.getContentID());
                    break;
                case "3":
                    article = contentArticleService.getContentByID(content.getContentID());
                    break;

                default:
                    break;
                }
            }
            
            switch (content.getContentType()) {
            case "2":
                // The product content
                List<String> dictClassCodes = new ArrayList<String>();
                dictClassCodes.add(DictConstant.FIELD_PRODUCT_TYPE);
                dictClassCodes.add(DictConstant.FIELD_PRODUCT_ORIGIN);
                dictClassCodes.add(DictConstant.FIELD_PRODUCT_COUNTRY);
                List<DictItemDto> dictItems = dictItemService.getByClassCode(dictClassCodes);

                productCountries = new ArrayList<DictItemDto>();
                productOrigins = new ArrayList<DictItemDto>();
                productTypes = new ArrayList<DictItemDto>();

                for (DictItemDto item : dictItems) {
                    switch (item.getDictClassCode()) {
                    case DictConstant.FIELD_PRODUCT_TYPE:
                        productTypes.add(item);
                        break;
                    case DictConstant.FIELD_PRODUCT_ORIGIN:
                        productOrigins.add(item);
                        break;
                    case DictConstant.FIELD_PRODUCT_COUNTRY:
                        productCountries.add(item);
                        break;
                    }
                }
                break;
            case "3":
                articleTypes = dictItemService.getByClassCode(DictConstant.DICT_CLASS_ARTICLE_TYPE);
                break;

            default:
                break;
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
            content.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
            switch (content.getContentType()) {
            case "2":
                contentDetailService.createContent(content, product);
                break;
            case "3":
                contentDetailService.createContent(content, article);
                break;
            default:
                contentDetailService.createContent(content);
                break;
            }
            // After create, the mode should be set as modify
            this.mode = 2;
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String update() {
        try {
            content.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));

            switch (content.getContentType()) {
            case "2":
                contentDetailService.updateContent(content, product);
                break;
            case "3":
                contentDetailService.updateContent(content, article);
                break;
            default:
                contentDetailService.updateContent(content);
                break;
            }
            this.mode = 2;
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String delete() {
        try {
            content.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
            contentService.deleteContent(content);
            
            this.mode = 4;
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
