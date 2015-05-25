package com.iidooo.cms.api.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.IChannelService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.action.BaseAPIAction;
import com.iidooo.core.constant.CoreConstants;

public class ChannelAction extends BaseAPIAction{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelAction.class);

    @Autowired
    private IChannelService channelService;

    public void channels() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String method = request.getMethod();
            switch (method) {
            case CoreConstants.HTTP_METHOD_GET:
                
                String siteCode = request.getParameter(CmsConstant.FIELD_SITE_CODE);

                if (siteCode == null || siteCode.isEmpty()) {
                    return;
                }
                
                List<ChannelDto> channelList = channelService.getChannelList(siteCode);

                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = JSONArray.fromObject(channelList);
                jsonObject.put(CmsConstant.REST_API_RESULT_CHANNEL_LIST, jsonArray);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentType(CoreConstants.APPLICATION_JSON);
                response.setCharacterEncoding(CoreConstants.ENCODING_UTF8);
                PrintWriter writer = response.getWriter();
                writer.write(jsonObject.toString());
                writer.close();
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
