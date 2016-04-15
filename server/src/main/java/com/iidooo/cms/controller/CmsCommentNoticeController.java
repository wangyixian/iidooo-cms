package com.iidooo.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.po.CmsCommentNotice;
import com.iidooo.cms.service.CmsCommentNoticeService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class CmsCommentNoticeController {

    private static final Logger logger = Logger.getLogger(CmsCommentNoticeController.class);

    @Autowired
    private CmsCommentNoticeService cmsCommentNoticeService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @RequestMapping(value = "/deleteCommentNotice", method = RequestMethod.POST)
    public @ResponseBody ResponseResult deleteCommentNotice(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String userID = request.getParameter("userID");
            String commentID = request.getParameter("commentID");
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
            if (StringUtil.isBlank(commentID)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "commentID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(commentID)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "commentID");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            CmsCommentNotice cmsCommentNotice = cmsCommentNoticeService.getCommentNotice(Integer.valueOf(userID), Integer.valueOf(commentID));
            if (cmsCommentNotice != null) {
                if (this.cmsCommentNoticeService.deleteCommentNotice(Integer.valueOf(userID), Integer.valueOf(commentID)) == false) {
                    result.setStatus(ResponseStatus.QueryEmpty.getCode());
                } else {
                    result.setStatus(ResponseStatus.OK.getCode());
                }

                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.CMS_COMMENT_NOTICE.toString(), cmsCommentNotice.getNoticeID(), request);

            } else {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            }
            
        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
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
            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.CMS_COMMENT_NOTICE.toString(), Integer.valueOf(userID), request);

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }
}
