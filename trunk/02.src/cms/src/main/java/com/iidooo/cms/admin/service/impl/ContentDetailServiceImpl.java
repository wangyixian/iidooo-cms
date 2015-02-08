package com.iidooo.cms.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.ContentDetailService;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
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
    private FieldDataDao fieldDataDao;

    @Override
    public boolean createContent(int userID, CmsContentDto content, List<FieldDataDto> fieldDataDtos) {
        try {
            content.setCommonData(userID, DateTimeUtil.getNow(DateConstant.FORMAT_DATETIME), true);
            // Set the default sequence
            int sequence = cmsContentDao.selectMaxSequence() + 1;
            content.setSequence(sequence);

            // Insert a new content into the DB
            int result = cmsContentDao.insert(content);

            // Insert the field data
            if (result > 0 && content.getContentID() != null && content.getContentID() > 0) {
                for (FieldDataDto item : fieldDataDtos) {
                    item.setTableDataID(content.getContentID());
                    item.setCommonData(userID, content.getCreateTime(), true);
                    fieldDataDao.insert(item);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean updateContent(int userID, CmsContentDto content, List<FieldDataDto> fieldDataDtos) {
        try {
            cmsContentDao.updateByPrimaryKey(content);

            for (FieldDataDto item : fieldDataDtos) {
                item.setCommonData(userID, DateTimeUtil.getNow(DateConstant.FORMAT_DATETIME), false);
                fieldDataDao.updateByPrimaryKey(item);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean deleteContent(int userID, CmsContentDto content, List<FieldDataDto> fieldDataDtos) {
        try {
            cmsContentDao.deleteByPrimaryKey(content);

            for (FieldDataDto item : fieldDataDtos) {
                item.setCommonData(userID, DateTimeUtil.getNow(DateConstant.FORMAT_DATETIME), false);
                fieldDataDao.deleteByPrimaryKey(item);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
