package com.iidooo.cms.freemarker.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iidooo.cms.constant.FreemarkerConstant;
import com.iidooo.cms.dao.extend.CmsAttachDao;
import com.iidooo.cms.dto.extend.CmsAttachDto;
import com.iidooo.framework.utility.FreeMarkerUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class AttachList implements TemplateDirectiveModel {

    private static final Logger logger = Logger.getLogger(AttachList.class);

    @Autowired
    private CmsAttachDao cmsAttachDao;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException,
            IOException {
        try {
            Map<String, Object> daoParams = FreeMarkerUtil.convertDirectiveParams(params);
            Map<String, List<CmsAttachDto>> albumMap = new HashMap<String, List<CmsAttachDto>>();

            List<CmsAttachDto> attachList = cmsAttachDao.selectAttachs(daoParams);
            for (CmsAttachDto cmsAttachDto : attachList) {
                String albumTitle = cmsAttachDto.getAlbumTitle();
                if (albumMap.containsKey(albumTitle)) {
                    List<CmsAttachDto> values = albumMap.get(albumTitle);
                    values.add(cmsAttachDto);
                } else {
                    List<CmsAttachDto> values = new ArrayList<CmsAttachDto>();
                    values.add(cmsAttachDto);
                    albumMap.put(albumTitle, values);
                }
            }

            FreeMarkerUtil.setDirectiveResult(albumMap, FreemarkerConstant.RETURN_MAP, env, body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }

}
