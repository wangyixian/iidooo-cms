package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.enums.ContentType;
import com.iidooo.cms.mapper.CmsContentMapper;
import com.iidooo.cms.mapper.CmsContentNewsMapper;
import com.iidooo.cms.mapper.CmsPictureMapper;
import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsPicture;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.model.Page;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private CmsContentMapper cmsContentDao;

    @Autowired
    private CmsContentNewsMapper cmsContentNewsDao;

    @Autowired
    private CmsPictureMapper cmsPictureDao;

    @Override
    public List<CmsContent> getContentListByType(String channelPath, String contentType, Page page) {
        try {
            List<CmsContent> result = new ArrayList<CmsContent>();

            if (contentType.equals(ContentType.News.getValue())) {
                result = cmsContentNewsDao.selectContentNewsList(channelPath, page);
            } else {
                result = cmsContentDao.selectContentListByType(channelPath, contentType, page);
            }

            List<CmsPicture> pictures = cmsPictureDao.selectByContentList(result);
            // Key: ContentID
            // Value: Picture List
            Map<Integer, List<CmsPicture>> picturesMap = new HashMap<Integer, List<CmsPicture>>();            
            for (CmsPicture item : pictures) {
                if (picturesMap.containsKey(item.getContentID())) {
                    picturesMap.get(item.getContentID()).add(item);
                } else {
                    List<CmsPicture> tempPictureList = new ArrayList<CmsPicture>();
                    tempPictureList.add(item);
                    picturesMap.put(item.getContentID(), tempPictureList);
                }
            }
            
            // Put the picture list into content
            for (CmsContent item : result) {
                if (picturesMap.containsKey(item.getContentID())) {
                    List<CmsPicture> pictureList = picturesMap.get(item.getContentID());
                    item.setPictureList(pictureList);
                }
            }

            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

}
