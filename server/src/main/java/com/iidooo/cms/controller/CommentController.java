package com.iidooo.cms.controller;

import java.util.Date;
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
import com.iidooo.cms.service.CmsCommentNoticeService;
import com.iidooo.cms.service.CommentService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.SortField;
import com.iidooo.core.enums.SortType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.model.po.SecurityUser;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.service.SecurityUserService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class CommentController {

    private static final Logger logger = Logger.getLogger(CommentController.class);
    
    @Autowired
    private CommentService commentService;

    @Autowired
    private CmsCommentNoticeService cmsCommentNoticeService;

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
            String contentIDStr = request.getParameter("contentID");
            String userIDStr = request.getParameter("userID");
            if (StringUtil.isBlank(contentIDStr)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(contentIDStr)) {
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

            int contentID = Integer.parseInt(contentIDStr);
            List<CmsComment> commentList = this.commentService.getCommentListByContentID(contentID, page);
            if (commentList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(commentList);
            }

            // 删除该用户对于该内容的评论通知
            if (StringUtil.isNotBlank(userIDStr)) {
                if (!ValidateUtil.isNumber(userIDStr)) {
                    Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                    result.getMessages().add(message);
                } else {
                    int userID = Integer.parseInt(userIDStr);
                    cmsCommentNoticeService.deleteCommentNoticeList(userID, contentID);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }

    @RequestMapping(value = "/getNoticeCommentList", method = RequestMethod.POST)
    public @ResponseBody ResponseResult getNoticeCommentList(HttpServletRequest request, HttpServletResponse response) {
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

            List<CmsComment> commentList = this.commentService.getNoticeCommentListByUserID(Integer.valueOf(userID), page);
            if (commentList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(commentList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
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
            String userIDStr = request.getParameter("userID");
            String contentIDStr = request.getParameter("contentID");
            String comment = request.getParameter("comment");

            result.checkFieldRequired("userID", userIDStr);
            result.checkFieldInteger("userID", userIDStr);
            result.checkFieldRequired("contentID", contentIDStr);
            result.checkFieldInteger("contentID", contentIDStr);
            result.checkFieldRequired("comment", comment);

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            String parentIDStr = request.getParameter("parentID");
            if (StringUtil.isBlank(parentIDStr)) {
                parentIDStr = "0";
            } else if (!ValidateUtil.isNumber(parentIDStr)) {
                result.checkFieldInteger("parentID", parentIDStr);
            }

            int userID = Integer.parseInt(userIDStr);
            int contentID = Integer.parseInt(contentIDStr);
            int parentID = Integer.parseInt(parentIDStr);

            // 判断用户是否可以创建评论IsSlient＝1
            SecurityUser userInfo = sercurityUserService.getSecurityUserByID(userID);
            if (userInfo == null || userInfo.getIsSilent() != 0 || userInfo.getIsDisable() != 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.ConfinedFailed.getCode());
                Message message = new Message(MessageType.IsSlient.getCode(), MessageLevel.WARN, "SecurityUserInfo.IsSlient");
                result.getMessages().add(message);
                return result;
            }

            // 判断内容是否允许被评论IsSlient=1
            CmsContent cmsContent = contentService.getContent(contentID);
            if (cmsContent != null && cmsContent.getIsSilent() != 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.ConfinedFailed.getCode());
                Message message = new Message(MessageType.IsSlient.getCode(), MessageLevel.WARN, "CmsContent.IsSlient");
                result.getMessages().add(message);
                return result;
            }

            CmsComment cmsComment = new CmsComment();
            cmsComment.setContentID(contentID);
            cmsComment.setParentID(parentID);
            cmsComment.setComment(comment);
            cmsComment.setCreateUserID(userID);
            cmsComment.setCreateTime(new Date());
            cmsComment.setUpdateUserID(cmsComment.getCreateUserID());
            cmsComment.setUpdateTime(new Date());

            CmsComment existComment = this.commentService.getCommentByInfo(userID, contentID, comment);
            if (existComment != null && DateUtil.subtract(new Date(), existComment.getCreateTime()) <= 30) {
                cmsComment = existComment;
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(cmsComment);
            }
            else {
                if (!this.commentService.createComment(cmsComment)) {
                    result.setStatus(ResponseStatus.InsertFailed.getCode());
                } else {
                    cmsComment = commentService.getCommentByID(cmsComment.getCommentID());
                    result.setStatus(ResponseStatus.OK.getCode());
                    result.setData(cmsComment);
                    // 更新内容的评论数
                    contentService.updateCommentCount(contentID);
                    // 更新浏览记录
                    hisOperatorService.createHisOperator(TableName.CMS_COMMENT.toString(), cmsComment.getCommentID(), request);
                }
            }          

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
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

            if (StringUtil.isBlank(commentID)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "commentID");
                result.getMessages().add(message);
            } else if (ValidateUtil.isNumber(commentID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "commentID");
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
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }
}
