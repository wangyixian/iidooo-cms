package com.iidooo.cms.freemarker.directive;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iidooo.cms.constant.FreemarkerConstant;
import com.iidooo.cms.dao.extend.CmsStatisticsDao;
import com.iidooo.framework.utility.FreeMarkerUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class Statistics implements TemplateDirectiveModel{
    private static final Logger logger = Logger.getLogger(Statistics.class);

    @Autowired
    private CmsStatisticsDao cmsStatisticsDao;
    
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException,
            IOException {
        try {
            Map<String, Object> daoParams = FreeMarkerUtil.convertDirectiveParams(params);
            int returnValue = 0;
            String contentID = (String)daoParams.get(FreemarkerConstant.PARAM_CONTENT_ID);
            String statisticsBy = (String)daoParams.get(FreemarkerConstant.PARAM_STATISTICS_BY);
            if (statisticsBy.equals(FreemarkerConstant.PARAM_STATISTICS_BY_PV)) {
                returnValue = cmsStatisticsDao.selectContentPV(Integer.parseInt(contentID));
            }
            FreeMarkerUtil.setDirectiveResult(returnValue, FreemarkerConstant.RETURN_VALUE, env, body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        
    }
}
