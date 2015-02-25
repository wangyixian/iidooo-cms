package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface CmsContentArticleDao {
    List<CmsContentArticleDto> selectContentArticles(@Param("channelID") int channelID, @Param("articleType") int articleType,
            @Param("count") int count);

    int selectArticlesCountByChannelID(int channelID);

    List<CmsContentArticleDto> selectArticlesByChannelID(@Param("channelID") int channelID, @Param("page") PagingDto page);

    CmsContentArticleDto selectByContentID(int contentID);

    int insert(CmsContentArticleDto article);

    int updateByPrimaryKey(CmsContentArticleDto article);
}
