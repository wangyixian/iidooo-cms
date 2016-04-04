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

import com.iidooo.cms.model.po.CmsCommentNotice;
import com.iidooo.cms.service.CmsCommentNoticeService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.SortField;
import com.iidooo.core.enums.SortType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class CmsCommentNoticeController {

    private static final Logger logger = Logger.getLogger(CmsCommentNoticeController.class);
    
    @Autowired
    private CmsCommentNoticeService cmsCommentNoticeService;
    
    @RequestMapping(value = "/getCommentNoticeList", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getCommentNoticeList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String userID = request.getParameter("userID");
            if (StringUtil.isBlank(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(userID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            String sortField = request.getParameter("sortField");
            if (StringUtil.isBlank(sortField)) {
                sortField = SortField.Sequence.toString();
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
            
            List<CmsCommentNotice> commentNoticeList = this.cmsCommentNoticeService.getCommentNoticeList(Integer.valueOf(userID), page);
            if (commentNoticeList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(commentNoticeList);
            }
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }
    
    @RequestMapping(value = "/getCommentNotice", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getCommentNotice(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String noticeID = request.getParameter("noticeID");
            if (StringUtil.isBlank(noticeID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "noticeID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(noticeID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "noticeID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }
            
            CmsCommentNotice commentNotice = this.cmsCommentNoticeService.getCommentNotice(Integer.valueOf(noticeID));
            if (commentNotice == null) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(commentNotice);
            }
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }
    
    @RequestMapping(value = "/deleteCommentNoticeList", method = RequestMethod.POST)
    public @ResponseBody ResponseResult deleteCommentNoticeList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String userID = request.getParameter("userID");
            if (StringUtil.isBlank(userID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(userID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }
            if (this.cmsCommentNoticeService.deleteCommentNoticeList(Integer.valueOf(userID)) == false) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
            }
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }
}
