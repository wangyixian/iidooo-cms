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

import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.vo.SecurityUserInfo;
import com.iidooo.cms.service.CommentService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.cms.service.HisOperatorService;
import com.iidooo.cms.service.SecurityUserService;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.SortField;
import com.iidooo.core.enums.SortType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class CommentController {

    private static final Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @Autowired
    private SecurityUserService sercurityUserService;

    @Autowired
    private ContentService contentService;
    
    @Autowired
    private HisOperatorService hisOperatorService;

    @RequestMapping(value = "/getCommentList", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getCommentList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String contentID = request.getParameter("contentID");
            if (StringUtil.isBlank(contentID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(contentID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "contentID");
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

            List<CmsComment> commentList = this.commentService.getCommentListByContentID(Integer.valueOf(contentID), page);
            if (commentList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(commentList);
            }
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public ResponseResult createComment(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String createUserID = request.getParameter("createUserID");
            String contentID = request.getParameter("contentID");
            String comment = request.getParameter("comment");

            if (StringUtil.isBlank(createUserID)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "createUserID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(createUserID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "createUserID");
                result.getMessages().add(message);
            }
            if (StringUtil.isBlank(contentID)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(contentID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
            }
            if (StringUtil.isBlank(comment)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "comment");
                result.getMessages().add(message);
            }

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            String parentID = request.getParameter("parentID");
            if (StringUtil.isBlank(parentID)) {
                parentID = "0";
            }

            // 判断用户是否可以创建评论IsSlient＝1
            SecurityUserInfo userInfo = sercurityUserService.getUserInfoByID(Integer.parseInt(createUserID));
            if (userInfo != null && userInfo.getIsSilent() != 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.ConfinedFailed.getCode());
                Message message = new Message(MessageType.IsSlient.getCode(), MessageLevel.WARN, "SecurityUserInfo.IsSlient");
                result.getMessages().add(message);
                return result;
            }

            // 判断内容是否允许被评论IsSlient=1
            CmsContent cmsContent = contentService.getContent(Integer.parseInt(contentID));
            if (cmsContent != null && cmsContent.getIsSilent() != 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.ConfinedFailed.getCode());
                Message message = new Message(MessageType.IsSlient.getCode(), MessageLevel.WARN, "CmsContent.IsSlient");
                result.getMessages().add(message);
                return result;
            }

            CmsComment cmsComment = new CmsComment();
            cmsComment.setComment(comment);
            cmsComment.setContentID(Integer.parseInt(contentID));
            cmsComment.setParentID(Integer.parseInt(parentID));
            cmsComment.setCreateUserID(Integer.parseInt(createUserID));
            if (!this.commentService.createComment(cmsComment)) {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
            } else {
                cmsComment = commentService.getCommentByID(cmsComment.getCommentID());
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(cmsComment);
            }
            
            // 更新内容的评论数
            contentService.updateCommentCount(Integer.parseInt(contentID));

            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.CMS_COMMENT.toString(), cmsComment.getCommentID(), request);
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    public @ResponseBody ResponseResult updateComment(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String commentID = request.getParameter("commentID");
            String comment = request.getParameter("comment");

            List<Message> messages = validateUpdateComment(commentID, comment);
            if (messages.size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                result.setMessages(messages);
                return result;
            }

            CmsComment cmsComment = new CmsComment();
            cmsComment.setComment(comment);
            cmsComment.setCommentID(Integer.parseInt(commentID));
            cmsComment = this.commentService.updateComment(cmsComment);
            if (cmsComment == null) {
                result.setStatus(ResponseStatus.UpdateFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(cmsComment);
            }
            
            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.CMS_COMMENT.toString(), cmsComment.getCommentID(), request);
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, e.getMessage());
            result.getMessages().add(message);
        }
        return result;
    }

    private List<Message> validateUpdateComment(String commentID, String comment) {
        List<Message> result = new ArrayList<Message>();
        try {
            if (StringUtil.isBlank(commentID)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "commentID");
                result.add(message);
            }

            if (StringUtil.isBlank(comment)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "comment");
                result.add(message);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.add(message);
        }
        return result;
    }
}
