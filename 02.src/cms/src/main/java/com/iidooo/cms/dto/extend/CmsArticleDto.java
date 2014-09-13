package com.iidooo.cms.dto.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsArticle;

public class CmsArticleDto extends CmsArticle{
    private List<CmsAttachmentDto> attachments;

    public List<CmsAttachmentDto> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<CmsAttachmentDto> attachments) {
        this.attachments = attachments;
    }

}