package com.iidooo.cms.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.ContentDetailService;
import com.iidooo.cms.dao.extend.CmsContentArticleDao;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dao.extend.CmsContentProductDao;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.framework.constant.DateConstant;
import com.iidooo.framework.dao.extend.FieldDataDao;
import com.iidooo.framework.dto.extend.FieldDataDto;
import com.iidooo.framework.utility.DateTimeUtil;

@Service
public class ContentDetailServiceImpl implements ContentDetailService {

    private static final Logger logger = Logger.getLogger(ContentDetailServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

    @Autowired
    private CmsContentArticleDao cmsContentArticleDao;

    @Autowired
    private CmsContentProductDao cmsContentProductDao;

    @Override
    public boolean createContent(CmsContentDto content) {
        try {
            // Set the default sequence
            int sequence = cmsContentDao.selectMaxSequence() + 1;
            content.setSequence(sequence);

            // Insert a new content into the DB
            int result = cmsContentDao.insert(content);

            if (result > 0 && content.getContentID() != null && content.getContentID() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean createContent(CmsContentDto content, CmsContentProductDto product) {
        try {
            if (this.createContent(content)) {
                product.setContentID(content.getContentID());
                cmsContentProductDao.insert(product);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean createContent(CmsContentDto content, CmsContentArticleDto article) {
        try {
            if (this.createContent(content)) {
                article.setContentID(content.getContentID());
                cmsContentArticleDao.insert(article);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean updateContent(CmsContentDto content) {
        try {
            int result = cmsContentDao.updateByPrimaryKey(content);

            if (result > 0 && content.getContentID() != null && content.getContentID() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean updateContent(CmsContentDto content, CmsContentProductDto product) {
        try {
            if (this.updateContent(content)) {
                product.setContentID(content.getContentID());
                cmsContentProductDao.updateByPrimaryKey(product);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean updateContent(CmsContentDto content, CmsContentArticleDto article) {
        try {
            if (this.updateContent(content)) {
                article.setContentID(content.getContentID());
                cmsContentArticleDao.updateByPrimaryKey(article);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean deleteContent(CmsContentDto content) {
        try {
            cmsContentDao.deleteByPrimaryKey(content);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }
}
