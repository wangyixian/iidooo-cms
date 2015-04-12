package com.iidooo.cms.dto.generate;

import com.iidooo.cms.dto.extend.CmsContentDto;

public class CmsContentArticle extends CmsContentDto{

    private String articleType;

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType == null ? null : articleType.trim();
    }
}