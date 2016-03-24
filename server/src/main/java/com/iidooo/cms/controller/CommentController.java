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

import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.cms.service.CommentService;
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
public class CommentController {

    private static final Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/getCommentList", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getCommentList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String contentID = request.getParameter("contentID");
            if (StringUtil.isBlank(contentID)) {
                // 验证失败，返回message
                Message message = new Message(MessageCode.FieldRequired, MessageType.ERROR, "contentID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed);
                return result;
            }

            String sortField = request.getParameter("sortField");
            if (StringUtil.isBlank(sortField)) {
                sortField = SortField.CreateTime.toString();
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

            List<CmsComment> commentList = this.commentService.getCommentListByContentID(Integer.valueOf(contentID), page);
            if (commentList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty);
            } else {
                result.setStatus(ResponseStatus.OK);
                result.setData(commentList);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageCode.Exception, MessageType.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }
}
