package com.iidooo.cms.action.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.content.IContentInfoService;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.tag.component.TreeNode;
import com.opensymphony.xwork2.ActionSupport;

public class ContentInfoAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentInfoAction.class);

    @Autowired
    private IContentInfoService contentInfoService;

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
