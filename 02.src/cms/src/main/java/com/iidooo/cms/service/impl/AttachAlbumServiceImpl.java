package com.iidooo.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsAttachAlbumDao;
import com.iidooo.cms.dao.extend.CmsAttachDao;
import com.iidooo.cms.dto.extend.CmsAttachAlbumDto;
import com.iidooo.cms.dto.extend.CmsAttachDto;
import com.iidooo.cms.service.AttachAlbumService;

@Service
public class AttachAlbumServiceImpl implements AttachAlbumService {

    private static final Logger logger = Logger.getLogger(AttachAlbumServiceImpl.class);

    @Autowired
    private CmsAttachAlbumDao cmsAttachAlbumDao;

    @Autowired
    private CmsAttachDao cmsAttachDao;

    public CmsAttachAlbumDto getAttachAlbumDto(int albumID) {
        try {
            CmsAttachAlbumDto attachAlbumDto = cmsAttachAlbumDao.selectAttachAlbumByID(albumID);
            if (attachAlbumDto != null) {
                List<CmsAttachDto> attachDtos = cmsAttachDao.selectAttachsByAlbumID(albumID);
                attachAlbumDto.setCmsAttachDtos(attachDtos);
            }

            List<CmsAttachAlbumDto> albums = cmsAttachAlbumDao.selectAttachAlbumsByClassify(attachAlbumDto);
            this.setPreNextAlbum(attachAlbumDto, albums);

            return attachAlbumDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    // Set the preview album and next album
    private void setPreNextAlbum(CmsAttachAlbumDto currentAlbum, List<CmsAttachAlbumDto> albums) {
        int size = albums.size();
        for (int i = 0; i < size; i++) {
            if (currentAlbum.getAlbumID() == albums.get(i).getAlbumID()) {
                // Get the preview album
                if ((i - 1) >= 0) {
                    currentAlbum.setPreAlbumID(albums.get(i - 1).getAlbumID());
                }

                // Get the next album
                if ((i + 1) < size) {
                    currentAlbum.setNextAlbumID(albums.get(i + 1).getAlbumID());
                }
            }
        }

        if (currentAlbum.getPreAlbumID() == null) {
            currentAlbum.setPreAlbumID(albums.get(size - 1).getAlbumID());
        }

        if (currentAlbum.getNextAlbumID() == null) {
            currentAlbum.setNextAlbumID(albums.get(0).getAlbumID());
        }
    }

}
