package com.iidooo.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsTemplateDao;
import com.iidooo.cms.dto.extend.CmsTemplateDto;
import com.iidooo.cms.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

    private static final Logger logger = Logger.getLogger(TemplateServiceImpl.class);
    
    @Autowired
    private CmsTemplateDao cmsTemplateDao;

    @Override
    public List<CmsTemplateDto> getAllTemplates() {
        try {
            List<CmsTemplateDto> cmsTemplateDtos = cmsTemplateDao.selectAll();
            return cmsTemplateDtos;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
