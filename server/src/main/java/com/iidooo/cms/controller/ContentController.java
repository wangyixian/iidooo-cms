package com.iidooo.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iidooo.cms.enums.ContentType;
import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsContentNews;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.SortField;
import com.iidooo.core.enums.SortType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class ContentController {

    private static final Logger logger = Logger.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @ResponseBody
    @RequestMapping(value = "/getContentPVSum", method = RequestMethod.POST)
    public ResponseResult getContentPVSum(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {

            int pvCount = hisOperatorService.getPVCount("CMS_CONTENT", null, "getContent");

            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("PVSum", pvCount);
            result.setData(jsonObject);

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
    @RequestMapping(value = "/getContent", method = RequestMethod.POST)
    public ResponseResult getContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 获取和验证字段
            String contentID = request.getParameter("contentID");
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

            // 查询获得内容对象
            CmsContent content = contentService.getContent(Integer.valueOf(contentID));
            if (content == null) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
                return result;
            }

            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(content);

            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.CMS_CONTENT.toString(), content.getContentID(), request);

            // 更新该内容的PV和UV
            String option = request.getServletPath().substring(1);
            int pvCount = hisOperatorService.getPVCount(TableName.CMS_CONTENT.toString(), content.getContentID(), option);
            int uvCount = hisOperatorService.getUVCount(TableName.CMS_CONTENT.toString(), content.getContentID(), option);
            contentService.updateViewCount(content.getContentID(), pvCount, uvCount);
            content.setPageViewCount(pvCount);
            content.setUniqueVisitorCount(uvCount);
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
    @RequestMapping(value = "/getContentList", method = RequestMethod.POST)
    public ResponseResult getContentList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String channelPath = request.getParameter("channelPath");
            String contentType = request.getParameter("contentType");
            if (StringUtil.isBlank(channelPath)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "channelPath");
                result.getMessages().add(message);
            }
            if (StringUtil.isBlank(contentType)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentType");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(contentType)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "contentType");
                result.getMessages().add(message);
            }

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
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

            CmsContent cmsContent = new CmsContent();
            cmsContent.setContentType(contentType);
            String createUserID = request.getParameter("createUserID");
            if (StringUtil.isNotBlank(createUserID)) {
                cmsContent.setCreateUserID(Integer.parseInt(createUserID));
            } else {
                cmsContent.setCreateUserID(null);
            }

            List<CmsContent> contentList = this.contentService.getContentListByType(channelPath, cmsContent, page);
            if (contentList.size() <= 0) {
                result.setStatus(ResponseStatus.QueryEmpty.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(contentList);
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

    @RequestMapping(value = "/createContent", method = RequestMethod.POST)
    public @ResponseBody ResponseResult createContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String channelIDStr = request.getParameter("channelID");
            String userIDStr = request.getParameter("userID");
            String contentType = request.getParameter("contentType");
            if (StringUtil.isBlank(channelIDStr)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "channelID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(channelIDStr)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "channelID");
                result.getMessages().add(message);
            }

            if (StringUtil.isBlank(userIDStr)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(userIDStr)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
            }

            if (StringUtil.isBlank(contentType)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentType");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(contentType)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "contentType");
                result.getMessages().add(message);
            }

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            int channelID = Integer.parseInt(channelIDStr);
            int userID = Integer.parseInt(userIDStr);

            // 获取可选参数
            String contentTitle = request.getParameter("contentTitle");
            String contentSubTitle = request.getParameter("contentSubTitle");
            String contentImageTitle = request.getParameter("contentImageTitle");
            String metaTitle = request.getParameter("metaTitle");
            String metaKeywords = request.getParameter("metaKeywords");
            String metaDescription = request.getParameter("metaDescription");
            String contentSummary = request.getParameter("contentSummary");
            String contentBody = request.getParameter("contentBody");
            String isSilent = request.getParameter("isSilent");
            String stickyIndex = request.getParameter("stickyIndex");
            String remarks = request.getParameter("remarks");

            // 工厂创建对象
            CmsContent content = null;
            if (contentType.equals(ContentType.Default.getCode())) {
                content = new CmsContent();
            } else if (contentType.equals(ContentType.News.getCode())) {
                content = new CmsContentNews();

                // 设置CmsContentNews参数
                String source = request.getParameter("source");
                String sourceURL = request.getParameter("sourceURL");
                CmsContentNews contentNews = (CmsContentNews) content;
                contentNews.setSource(source);
                contentNews.setSourceURL(sourceURL);
            }

            // 设置CmsContent属性
            content.setChannelID(channelID);
            content.setContentType(contentType);
            content.setContentTitle(contentTitle);
            content.setMetaKeywords(metaKeywords);
            content.setContentSubTitle(contentSubTitle);
            content.setContentImageTitle(contentImageTitle);
            content.setMetaTitle(metaTitle);
            content.setMetaDescription(metaDescription);
            content.setContentSummary(contentSummary);
            content.setContentBody(contentBody);
            if (StringUtil.isNotBlank(isSilent) && ValidateUtil.isNumber(isSilent)) {
                content.setIsSilent(Integer.parseInt(isSilent));
            }
            if (StringUtil.isNotBlank(stickyIndex) && ValidateUtil.isNumber(stickyIndex)) {
                content.setStickyIndex(Integer.parseInt(stickyIndex));
            }
            content.setStartShowDate("");
            content.setStartShowTime("00:00:00");
            content.setEndShowDate("");
            content.setEndShowTime("23:59:59");
            content.setRemarks(remarks);
            content.setCreateTime(new Date());
            content.setCreateUserID(userID);
            content.setUpdateTime(new Date());
            content.setUpdateUserID(userID);
            
            if(contentService.createContent(content)){
                content = contentService.getContent(content.getContentID());
            }
            if (content == null) {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(content);
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.setStatus(ResponseStatus.Failed.getCode());
            result.getMessages().add(message);
        }
        return result;
    }
}
