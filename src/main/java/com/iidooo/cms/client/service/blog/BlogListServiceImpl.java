package com.iidooo.cms.client.service.blog;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentArticleDao;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class BlogListServiceImpl implements BlogListService{
    
    private static final Logger logger = Logger.getLogger(BlogListServiceImpl.class);
    
    @Autowired
    private CmsContentArticleDao cmsContentArticleDao;
    
    
    @Override
    public int getArticlesCount(int channelID) {
        try {
            int count = cmsContentArticleDao.selectArticlesCountByChannelID(channelID);
            return count;
      } catch (Exception e) {
          e.printStackTrace();
          logger.fatal(e);
          return 0;
      }
    }


    @Override
    public List<CmsContentArticleDto> getArticles(int channelID, PagingDto page) {
        List<CmsContentArticleDto> articles = new ArrayList<CmsContentArticleDto>();        
        try {
            articles = cmsContentArticleDao.selectArticlesByChannelID(channelID, page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        
        return articles;
    }

}
