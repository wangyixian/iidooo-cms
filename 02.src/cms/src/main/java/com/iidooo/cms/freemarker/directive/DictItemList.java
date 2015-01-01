package com.iidooo.cms.freemarker.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iidooo.cms.constant.FreemarkerConstant;
import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.utility.FreeMarkerUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class DictItemList implements TemplateDirectiveModel {

    private static final Logger logger = Logger.getLogger(DictItemList.class);

    @Autowired
    private DictItemDao dictItemDao;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException,
            IOException {
        try {
            Map<String, Object> daoParams = FreeMarkerUtil.convertDirectiveParams(params);            
            String tagClass = (String)daoParams.get(FreemarkerConstant.PARAM_TAG_CLASS);
            List<DictItemDto> dictItemList = dictItemDao.selectByClassCode(tagClass); 
            FreeMarkerUtil.setDirectiveResult(dictItemList, FreemarkerConstant.RETURN_LIST, env, body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }

}