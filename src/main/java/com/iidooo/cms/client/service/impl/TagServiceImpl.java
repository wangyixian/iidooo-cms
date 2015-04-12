package com.iidooo.cms.client.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.client.service.TagService;
import com.iidooo.cms.dao.extend.CmsContentTagDao;
import com.iidooo.cms.dto.extend.CmsContentTagDto;

@Service
public class TagServiceImpl implements TagService {

    private static final Logger logger = Logger.getLogger(TagServiceImpl.class);

    @Autowired
    private CmsContentTagDao cmsTagDao;

    public List<CmsContentTagDto> getContentTags(int contentID) {
        try {
            List<CmsContentTagDto> cmsTagDtos = cmsTagDao.selectTagsByContentID(contentID);
            return cmsTagDtos;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.getMessage());
            return null;
        }
    }

}
