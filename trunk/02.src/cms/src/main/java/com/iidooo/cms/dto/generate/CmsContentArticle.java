package com.iidooo.cms.dto.generate;

import com.iidooo.cms.dto.extend.CmsContentDto;

public class CmsContentArticle extends CmsContentDto{

    private Integer articleType;

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }
}