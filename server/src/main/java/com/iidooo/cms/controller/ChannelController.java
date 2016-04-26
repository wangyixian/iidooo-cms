package com.iidooo.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.model.po.CmsChannel;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;

@Controller
public class ChannelController {
    private static final Logger logger = Logger.getLogger(ChannelController.class);
    
    @Autowired
    private ChannelService channelService;
    
    @ResponseBody
    @RequestMapping(value = "/admin/getChannelList", method = RequestMethod.POST)
    public ResponseResult getChannelList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            
            List<CmsChannel> channels = channelService.getAllChannelList();   

            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(channels);
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.toString());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/admin/searchChannelList", method = RequestMethod.POST)
    public ResponseResult searchChannelList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            
            List<CmsChannel> channels = channelService.getAllChannelList();   

            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(channels);
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.toString());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }
}
