package com.iidooo.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.enums.MessageCode;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.SortField;
import com.iidooo.core.enums.SortType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.util.StringUtil;

@Controller
public class ContentController {

    private static final Logger logger = Logger.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/getContentList", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getContentList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String channelPath = request.getParameter("channelPath");
            String contentType = request.getParameter("contentType");
            List<Message> messages = validateGetContentList(channelPath, contentType);
            if (messages.size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed);
                result.setMessages(messages);
                return result;
            }
            
            String sortField = request.getParameter("sortField");
            if (StringUtil.isBlank(sortField)) {
                sortField = SortField.UpdateTime.toString();
            } 
            
            String sortType = request.getParameter("sortType");
            if (StringUtil.isBlank(sortType)) {
                sortType = SortType.desc.toString();
            }
            
            String start = request.getParameter("start");
            if (StringUtil.isBlank(start)) {
                start = "0";
            }
            
            String pageSize = request.getParameter("pageSize");
            if (StringUtil.isBlank(pageSize)) {
                pageSize = "10";
            }
            
            Page page = new Page();
            page.setSortField(sortField);
            page.setSortType(sortType);
            page.setStart(Integer.valueOf(start));
            page.setPageSize(Integer.valueOf(pageSize));
            
            List<CmsContentDto> contentList = this.contentService.getContentListByType(channelPath, contentType, page);
            if (contentList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty);
            } else {
                result.setStatus(ResponseStatus.OK);
                result.setData(contentList);
            }
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageCode.Exception, MessageType.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }
    
    private List<Message> validateGetContentList(String channelPath, String contentType) {
        List<Message> result = new ArrayList<Message>();
        try {
            if (StringUtil.isBlank(channelPath)) {
                Message message = new Message(MessageCode.FieldRequired, MessageType.WARN, "channelPath");
                result.add(message);
            }

            if (StringUtil.isBlank(contentType)) {
                Message message = new Message(MessageCode.FieldRequired, MessageType.WARN, "contentType");
                result.add(message);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageCode.Exception, MessageType.FATAL);
            message.setDescription(e.getMessage());
            result.add(message);
        }
        return result;
    }
}
