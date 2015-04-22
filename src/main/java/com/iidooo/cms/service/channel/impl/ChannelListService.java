package com.iidooo.cms.service.channel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelListService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.HttpUtil;
import com.iidooo.passport.filter.SSOFilter;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ChannelListService implements IChannelListService {

    private static final Logger logger = Logger.getLogger(ChannelListService.class);

    @Autowired
    private ChannelDao channelDao;

    @Override
    public List<ChannelDto> getChildrenChannelList(int parentID) {
        List<ChannelDto> result = new ArrayList<ChannelDto>();
        try {
            result = channelDao.selectByParentID(parentID);

            String url = (String) ActionContext.getContext().getApplication().get(CmsConstant.PASSPORT_URL);

            for (ChannelDto item : result) {
                JSONObject jsonCreateUser = new JSONObject();
                jsonCreateUser.put(url, item.getCreateUser());
                jsonCreateUser = HttpUtil.doPost(url, jsonCreateUser);

                JSONObject jsonUpdateUser = new JSONObject();
                jsonUpdateUser.put(url, item.getCreateUser());
                jsonUpdateUser = HttpUtil.doPost(url, jsonUpdateUser);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @Override
    public boolean deleteChannel(ChannelDto channel) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            int userID = (int) sessionMap.get(SSOFilter.USER_ID);
            channel.setUpdateUser(userID);
            channel.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            int count = channelDao.deleteByPrimaryKey(channel);
            if (count <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

}
