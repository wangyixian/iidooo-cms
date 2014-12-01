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
import com.iidooo.cms.dao.extend.CmsAttachAlbumDao;
import com.iidooo.cms.dto.extend.CmsAttachAlbumDto;
import com.iidooo.framework.utility.FreeMarkerUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class AttachAlbumList implements TemplateDirectiveModel {

    private static final Logger logger = Logger.getLogger(AttachAlbumList.class);

    @Autowired
    private CmsAttachAlbumDao cmsAttachAlbumDao;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException,
            IOException {
        try {
            Map<String, Object> daoParams = FreeMarkerUtil.convertDirectiveParams(params);
            Map<String, List<CmsAttachAlbumDto>> albumMap = new HashMap<String, List<CmsAttachAlbumDto>>();

            List<CmsAttachAlbumDto> albumList = cmsAttachAlbumDao.selectAttachAlbums(daoParams);
            for (CmsAttachAlbumDto cmsAttachAlbumDto : albumList) {
                String classifyName = cmsAttachAlbumDto.getClassifyName();
                if (albumMap.containsKey(classifyName)) {
                    List<CmsAttachAlbumDto> values = albumMap.get(classifyName);
                    values.add(cmsAttachAlbumDto);
                } else {
                    List<CmsAttachAlbumDto> values = new ArrayList<CmsAttachAlbumDto>();
                    values.add(cmsAttachAlbumDto);
                    albumMap.put(classifyName, values);
                }
            }

            FreeMarkerUtil.setDirectiveResult(albumMap, FreemarkerConstant.RETURN_MAP, env, body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }

}
