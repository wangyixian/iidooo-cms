package com.iidooo.cms.freemarker.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iidooo.cms.constant.FreemarkerConstant;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.utility.FreeMarkerUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class ContentList implements TemplateDirectiveModel {
    private static final Logger logger = Logger.getLogger(ContentList.class);

    @Autowired
    private CmsContentDao cmsContentDao;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException,
            IOException {
        try {
            Map<String, Object> daoParams = FreeMarkerUtil.convertDirectiveParams(params);
            List<CmsContentDto> cmsContentDtos = new ArrayList<CmsContentDto>();
            String sortBy = (String)daoParams.get(FreemarkerConstant.PARAM_SORT_BY);
            
            //For use the SQL IN, should split the multiple string[]
            if (daoParams.containsKey(FreemarkerConstant.PARAM_TAG_ITEMS)) {
                String tagItems = (String)daoParams.get(FreemarkerConstant.PARAM_TAG_ITEMS);
                String[] tagItemArray = tagItems.split(",");
                daoParams.put(FreemarkerConstant.PARAM_TAG_ITEMS, tagItemArray);                
            }
            
            if (sortBy.equals(FreemarkerConstant.PARAM_SORT_BY_PV)) {
                cmsContentDtos = cmsContentDao.selectContentsByPV(daoParams);
            } else if (sortBy.equals(FreemarkerConstant.PARAM_SORT_BY_TAG)) {
                cmsContentDtos = cmsContentDao.selectContentsByTag(daoParams);
            } else {
                cmsContentDtos = cmsContentDao.selectContents(daoParams);
            }
            FreeMarkerUtil.setDirectiveResult(cmsContentDtos, FreemarkerConstant.RETURN_LIST, env, body);
           
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }

}
