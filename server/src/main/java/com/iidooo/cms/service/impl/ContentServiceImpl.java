package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dao.extend.CmsContentNewsDao;
import com.iidooo.cms.dao.extend.CmsPictureDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsPictureDto;
import com.iidooo.cms.enums.ContentType;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.model.Page;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

    @Autowired
    private CmsContentNewsDao cmsContentNewsDao;

    @Autowired
    private CmsPictureDao cmsPictureDao;

    @Override
    public List<CmsContentDto> getContentListByType(String channelPath, String contentType, Page page) {
        try {
            List<CmsContentDto> result = new ArrayList<CmsContentDto>();

            if (contentType.equals(ContentType.News.getValue())) {
                result = cmsContentNewsDao.selectContentNewsList(channelPath, page);
            } else {
                result = cmsContentDao.selectContentListByType(channelPath, contentType, page);
            }

            List<CmsPictureDto> pictures = cmsPictureDao.selectByContentList(result);
            // Key: ContentID
            // Value: Picture List
            Map<Integer, List<CmsPictureDto>> picturesMap = new HashMap<Integer, List<CmsPictureDto>>();            
            for (CmsPictureDto item : pictures) {
                if (picturesMap.containsKey(item.getContentID())) {
                    picturesMap.get(item.getContentID()).add(item);
                } else {
                    List<CmsPictureDto> tempPictureList = new ArrayList<CmsPictureDto>();
                    tempPictureList.add(item);
                    picturesMap.put(item.getContentID(), tempPictureList);
                }
            }

            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

}
