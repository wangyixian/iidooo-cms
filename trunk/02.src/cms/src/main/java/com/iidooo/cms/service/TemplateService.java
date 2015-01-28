package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsTemplateDto;


public interface TemplateService {
    /**
     * Get all of the templates
     * @return The list of the CmsTemplateDto
     */
    List<CmsTemplateDto> getAllTemplates();
}
