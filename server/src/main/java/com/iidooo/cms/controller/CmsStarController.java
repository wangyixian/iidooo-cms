package com.iidooo.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.po.CmsStar;
import com.iidooo.cms.service.CmsStarService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class CmsStarController {

    private static final Logger logger = Logger.getLogger(CmsStarController.class);

    @Autowired
    private CmsStarService cmsStarService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @ResponseBody
    @RequestMapping(value = "/starContent", method = RequestMethod.POST)
    public ResponseResult starContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String createUserID = request.getParameter("createUserID");
            String contentID = request.getParameter("contentID");

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

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            CmsStar cmsStar = this.cmsStarService.starContent(Integer.parseInt(contentID), Integer.parseInt(createUserID));
            if (cmsStar == null) {
                Message message = new Message(MessageType.Information.getCode(), MessageLevel.INFO);
                message.setDescription("Star content failed, because you are already starred this content!");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.OK.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("contentID", Integer.parseInt(contentID));
                jsonObject.put("createUserID", Integer.parseInt(createUserID));
                jsonObject.put("starCount", contentService.getContentStarCount(Integer.parseInt(contentID)));

                result.setData(jsonObject);
                
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.CMS_STAR.toString(), cmsStar.getStartID(), request);
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

    @ResponseBody
    @RequestMapping(value = "/unstarContent", method = RequestMethod.POST)
    public ResponseResult unstarContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String createUserID = request.getParameter("createUserID");
            String contentID = request.getParameter("contentID");

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

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            CmsStar cmsStar = this.cmsStarService.starContent(Integer.parseInt(contentID), Integer.parseInt(createUserID));
            if (cmsStar == null) {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("contentID", Integer.parseInt(contentID));
                jsonObject.put("createUserID", Integer.parseInt(createUserID));
                jsonObject.put("starCount", contentService.getContentStarCount(Integer.parseInt(contentID)));

                result.setData(jsonObject);
            }

            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.CMS_STAR.toString(), cmsStar.getStartID(), request);

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
