package com.iidooo.cms.dto.extend;

import java.util.HashMap;

import com.iidooo.cms.dto.generate.CmsPage;

public class CmsPageDto extends CmsPage {
    private HashMap<String, CmsBlockDto> blockMap;

    private CmsArticleDto article;

    public HashMap<String, CmsBlockDto> getBlockMap() {
        return blockMap;
    }

    public void setBlockMap(HashMap<String, CmsBlockDto> blockMap) {
        this.blockMap = blockMap;
    }

    public CmsArticleDto getArticle() {
        return article;
    }

    public void setArticle(CmsArticleDto article) {
        this.article = article;
    }

}