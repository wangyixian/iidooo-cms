package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iidooo.cms.enums.ContentType;
import com.iidooo.cms.mapper.CmsCommentMapper;
import com.iidooo.cms.mapper.CmsContentMapper;
import com.iidooo.cms.mapper.CmsContentNewsMapper;
import com.iidooo.cms.mapper.CmsPictureMapper;
import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsContentNews;
import com.iidooo.cms.model.po.CmsPicture;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.model.Page;
import com.iidooo.core.util.DateUtil;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private CmsContentMapper cmsContentDao;

    @Autowired
    private CmsContentNewsMapper cmsContentNewsDao;

    @Autowired
    private CmsPictureMapper cmsPictureDao;

    @Autowired
    private CmsCommentMapper cmsCommentMapper;

    @Override
    public CmsContent getContent(Integer contentID) {
        try {
            CmsContent result = null;

            result = cmsContentNewsDao.selectByContentID(contentID);
            if (result == null) {
                result = cmsContentDao.selectByContentID(contentID);
            }

            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public List<CmsContent> getContentListByType(String channelPath, CmsContent cmsContent, Page page) {
        try {
            List<CmsContent> result = new ArrayList<CmsContent>();

            String contentType = cmsContent.getContentType();
            if (contentType.equals(ContentType.News.getCode())) {
                result = cmsContentNewsDao.selectContentNewsList(channelPath, cmsContent.getCreateUserID(), page);
            } else {
                result = cmsContentDao.selectContentListByChannelPath(channelPath, cmsContent.getCreateUserID(), page);
            }
            if (result.size() > 0) {

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
            }

            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean createContent(CmsContent content) throws Exception {
        try {            
            if (cmsContentDao.insert(content) <= 0) {
                throw new Exception();
            }

            if (content.getContentType().equals(ContentType.News.getCode())) {
                CmsContentNews cmsContentNews = (CmsContentNews) content;
                if (cmsContentNewsDao.insert(cmsContentNews) <= 0) {
                    throw new Exception();
                }
            }

            // for (CmsPicture picture : content.getPictureList()) {
            // picture.setContentID(content.getContentID());
            // if (cmsPictureDao.insert(picture) <= 0) {
            // throw new Exception();
            // }
            // }

            return true;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public int getUserContentCount(Integer userID) {
        try {
            int result = cmsContentDao.selectCountByUserID(userID);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public void updateViewCount(Integer contentID, int pvCount, int uvCount) {
        try {
            cmsContentDao.updateViewCount(contentID, pvCount, uvCount);
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    @Override
    public void updateCommentCount(Integer contentID) {
        try {
            int commentCount = cmsCommentMapper.selectCommentCount(contentID);
            cmsContentDao.updateCommentCount(contentID, commentCount);
        } catch (Exception e) {
            logger.fatal(e);
        }

    }

    @Override
    public int getContentStarCount(Integer contentID) {
        try {
            return cmsContentDao.selectStarCount(contentID);

        } catch (Exception e) {
            logger.fatal(e);
            return 0;
        }
    }

}
