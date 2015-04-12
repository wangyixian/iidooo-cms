package com.iidooo.cms.client.service.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentProductDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class ProductListServiceImpl implements ProductListService{
    private static final Logger logger = Logger.getLogger(ProductListServiceImpl.class);

    @Autowired
    private CmsContentProductDao contentProductDao;
    
    @Override
    public int searchCount(List<CmsChannelDto> channels, CmsContentProductDto product) {
        int count = 0;
        try {
            count = contentProductDao.selectProductsCount(channels, product);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return count;
    }

    @Override
    public List<CmsContentProductDto> search(List<CmsChannelDto> channels, CmsContentProductDto product, PagingDto page) {
        List<CmsContentProductDto> contentProducts = new ArrayList<CmsContentProductDto>();
        try {
            contentProducts = contentProductDao.selectProducts(channels, product, page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return contentProducts;
    }
}
