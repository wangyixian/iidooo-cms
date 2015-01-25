package com.iidooo.cms.admin.service.impl.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.channel.ChannelListService;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.exception.ExclusiveException;

@Service
public class ChannelListServiceImpl implements ChannelListService {

    private static final Logger logger = Logger.getLogger(ChannelListServiceImpl.class);

    @Autowired
    private CmsChannelDao cmsChannelDao;

    @Override
    public List<CmsChannelDto> getChannelList(int parentID) {
        try {
            List<CmsChannelDto> channelList = null;
            channelList = cmsChannelDao.selectChannelsByParentID(parentID);
            return channelList;
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
}
