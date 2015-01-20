package com.iidooo.cms.client.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.client.service.AttachService;
import com.iidooo.cms.dao.extend.CmsAttachDao;
import com.iidooo.cms.dto.extend.CmsAttachDto;

@Service
public class AttachServiceImpl implements AttachService {
    private static final Logger logger = Logger.getLogger(AttachServiceImpl.class);

    @Autowired
    private CmsAttachDao cmsAttachDao;

    public CmsAttachDto getAttachDtoByID(int attachID) {
        try {
            CmsAttachDto attachDto = cmsAttachDao.selectAttachByID(attachID);
            return attachDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
    
    
}
