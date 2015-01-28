package com.iidooo.cms.admin.service.impl.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.channel.ChannelDetailService;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dao.extend.CmsTemplateDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;
import com.iidooo.framework.exception.ExclusiveException;

@Service
public class ChannelDetailServiceImpl implements ChannelDetailService {
    private static final Logger logger = Logger.getLogger(ChannelDetailServiceImpl.class);

    @Autowired
    private CmsChannelDao cmsChannelDao;

    @Override
    public boolean createChannel(CmsChannelDto channel) {
        try {
            setChannelLevel(channel);
            setChannelSequence(channel);
            cmsChannelDao.insert(channel);
            channel.setChannelID(channel.getChannelID());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public CmsChannelDto getCurrentChannel(int channelID) {
        try {
            CmsChannelDto cmsChannelDto = cmsChannelDao.selectChannelByID(channelID);
            return cmsChannelDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }


    @Override
    public CmsChannelDto getChannelByPath(String channelPath) {
        try {
            CmsChannelDto cmsChannelDto = cmsChannelDao.selectChannelByPath(channelPath);
            return cmsChannelDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean updateChannel(CmsChannelDto channel) throws Exception {
        try {
            int count = cmsChannelDao.exclusiveCheck(channel.getChannelID(), channel.getVersion());
            if (count <= 0) {
                ExclusiveException exclusiveException = new ExclusiveException();
                throw (exclusiveException);
            }
            setChannelLevel(channel);
            setChannelSequence(channel);
            cmsChannelDao.update(channel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean deleteChannel(CmsChannelDto channel) throws Exception {
        try {
            int count = cmsChannelDao.exclusiveCheck(channel.getChannelID(), channel.getVersion());
            if (count <= 0) {
                ExclusiveException exclusiveException = new ExclusiveException();
                throw (exclusiveException);
            }
            cmsChannelDao.delete(channel.getChannelID());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    private void setChannelLevel(CmsChannelDto channel) {
        try {
            CmsChannelDto parentChannel = cmsChannelDao.selectChannelByID(channel.getParentID());
            if (parentChannel == null) {
                channel.setChannelLevel(1);
            } else {
                channel.setChannelLevel(parentChannel.getChannelLevel() + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    private void setChannelSequence(CmsChannelDto channel) {
        try {
            int sequence = 1;
            List<CmsChannelDto> channelDtos = cmsChannelDao.selectChannelsByParentID(channel.getParentID());
            if (channelDtos != null) {
                for (CmsChannelDto cmsChannelDto : channelDtos) {
                    if (cmsChannelDto.getSequence() > sequence) {
                        sequence = cmsChannelDto.getSequence() + 1;
                    }
                }
            }
            channel.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
