package com.iidooo.cms.admin.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.ContentDetailService;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.cms.service.ContentArticleService;
import com.iidooo.cms.service.ContentProductService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.action.BaseDetailAction;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.tag.TreeNode;

public class ContentDetailAction extends BaseDetailAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ContentService contentService;
    
    @Autowired
    private ContentProductService contentProductService;

    @Autowired
    private ContentArticleService contentArticleService;
    
    @Autowired
    private ContentDetailService contentDetailService;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }

    public void setRootTreeNode(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }

    private CmsContentDto content;

    public CmsContentDto getContent() {
        return content;
    }

    public void setContent(CmsContentDto content) {
        this.content = content;
    }

    private List<CmsChannelDto> allChannels;

    public List<CmsChannelDto> getAllChannels() {
        return allChannels;
    }

    public void setAllChannels(List<CmsChannelDto> allChannels) {
        this.allChannels = allChannels;
    }

    // Product Content
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

    private CmsContentProductDto product;

    public CmsContentProductDto getProduct() {
        return product;
    }

    public void setProduct(CmsContentProductDto product) {
        this.product = product;
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

    @Override
    public String init() {
        try {
            rootTreeNode = channelService.getRootTree(getText("LABEL_TREE_ROOT"), URLConstant.CONTENT_LIST_INIT);
            allChannels = channelService.getAllChannels();

            // The modify mode
            if (content != null && content.getContentID() != null && content.getContentID() > 0) {
                content = contentService.getContentByID(content.getContentID());
                switch (content.getContentType()) {
                case "2":                 
                    product = contentProductService.getContentByID(content.getContentID());
                    break;
                case "3":
                    article = contentArticleService.getContentByID(content.getContentID());
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

    @Override
    public String create() {
        try {
            SecurityUserDto securityUserDto = (SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER);
            // contentDetailService.createContent(securityUserDto.getUserID(), content, fieldDatas);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    @Override
    public String update() {
        try {

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    @Override
    public String delete() {
        try {

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void uploadImageTitle() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
