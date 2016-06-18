package com.iidooo.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iidooo.cms.enums.ContentType;
import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsContentNews;
import com.iidooo.cms.model.po.CmsFavorite;
import com.iidooo.cms.model.po.CmsPicture;
import com.iidooo.cms.service.ContentService;
import com.iidooo.cms.service.FavoriteService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.enums.SortField;
import com.iidooo.core.enums.SortType;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.model.po.SecurityUser;
import com.iidooo.core.service.DictItemService;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.service.SecurityUserService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.FileUtil;
import com.iidooo.core.util.PageUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;
import com.iidooo.weixin.entity.Signature;
import com.iidooo.weixin.thread.WeixinThread;
import com.iidooo.weixin.util.WeixinUtil;

@Controller
public class ContentController {

    private static final Logger logger = Logger.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @Autowired
    private DictItemService dictItemService;

    @Autowired
    private FavoriteService favoriteService;
    

    @Autowired
    private SecurityUserService sercurityUserService;

    @ResponseBody
    @RequestMapping(value = "/admin/searchContentList", method = RequestMethod.POST)
    public ResponseResult searchContentList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String channelID = request.getParameter("channelID");
            String contentTitle = request.getParameter("contentTitle");
            String contentType = request.getParameter("contentType");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String status = request.getParameter("status");
            String userID = request.getParameter("userID");

            if (StringUtil.isNotBlank(startDate)) {
                startDate = startDate + " 00:00:00";
            }

            if (StringUtil.isNotBlank(endDate)) {
                startDate = startDate + " 23:59:59";
            }

            CmsContent cmsContent = new CmsContent();
            cmsContent.setChannelID(Integer.valueOf(channelID));
            cmsContent.setContentTitle(contentTitle);
            cmsContent.setContentType(contentType);
            cmsContent.setStatus(status);
            if (StringUtil.isNotBlank(userID)) {
                cmsContent.setCreateUserID(Integer.parseInt(userID));
            }
            int recordSum = contentService.getContentListCount(cmsContent, startDate, endDate);

            String sortField = request.getParameter("sortField");
            String sortType = request.getParameter("sortType");
            Page page = new Page(sortField, sortType);
            String pageSize = request.getParameter("pageSize");
            if (StringUtil.isNotBlank(pageSize) && ValidateUtil.isNumber(pageSize)) {
                page.setPageSize(Integer.parseInt(pageSize));
            }
            String currentPage = request.getParameter("currentPage");
            if (StringUtil.isNotBlank(currentPage) && ValidateUtil.isNumber(currentPage) && Integer.parseInt(currentPage) > 0) {
                page.setCurrentPage(Integer.parseInt(currentPage));
            }
            page = PageUtil.executePage(recordSum, page);

            Map<String, Object> data = new HashMap<String, Object>();
            List<CmsContent> contentList = contentService.getContentList(cmsContent, startDate, endDate, page);
            data.put("page", page);
            data.put("contentList", contentList);
            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(data);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/admin/deleteContent", method = RequestMethod.POST)
    public ResponseResult deleteContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            String contentIDStr = request.getParameter("contentID");
            String userIDStr = request.getParameter("userID");

            if (StringUtil.isBlank(contentIDStr)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(contentIDStr)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
            }

            if (StringUtil.isBlank(userIDStr)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(userIDStr)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "userID");
                result.getMessages().add(message);
            }

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            CmsContent content = new CmsContent();
            content.setContentID(Integer.parseInt(contentIDStr));
            content.setUpdateUserID(Integer.parseInt(userIDStr));
            contentService.deleteContent(content);

            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            result.setData("success");
            // 更新浏览记录
            hisOperatorService.createHisOperator(TableName.CMS_CONTENT.toString(), content.getContentID(), request);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }

    @RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
    public ModelAndView content(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView result = new ModelAndView("/resources/share.jsp");
        try {
            // 查询获得内容对象
            CmsContent content = contentService.getContent(id);
            if (content == null) {
                result.setViewName("/resources/404.html");
            } else {
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.CMS_CONTENT.toString(), content.getContentID(), request);
                // 更新该内容的PV和UV
                // UV 的统计需要两个接口的请求
                List<String> optionList = new ArrayList<String>();
                optionList.add(request.getServletPath().substring(1));
                optionList.add("getContent");
                int pvCount = content.getPageViewCount() + 1;
                int uvCount = hisOperatorService.getUVCount(TableName.CMS_CONTENT.toString(), content.getContentID(), optionList);
                contentService.updateViewCount(content.getContentID(), pvCount, uvCount);
                content.setPageViewCount(pvCount);
                content.setUniqueVisitorCount(uvCount);

                result.addObject("content", content);
                String source = "";
                String sourceURL = "";
                if (content.getContentType().equals(ContentType.News.getCode())) {
                    CmsContentNews contentNews = (CmsContentNews)content;
                    source = contentNews.getSource();
                    sourceURL = contentNews.getSourceURL();
                }
                result.addObject("source", source);
                result.addObject("sourceURL", sourceURL);
                
                // 处理微信分享JS SDK的相关参数
                String jsAPITicket = WeixinThread.getJsAPITicket().getTicket();
                String url = request.getRequestURL().toString();
                if (request.getQueryString() != null && request.getQueryString().length() > 0) {
                    url = url + "?" + request.getQueryString();
                }
                Signature signature = WeixinUtil.getSignature(jsAPITicket, url);
                result.addObject("signature", signature);
                result.addObject("appID", WeixinThread.getAppID());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = { "/getContent", "/admin/getContent" }, method = RequestMethod.POST)
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

            String userIDStr = request.getParameter("userID");
            Integer userID = null;
            if (StringUtil.isNotBlank(userIDStr) && ValidateUtil.isNumber(userIDStr)) {
                userID = Integer.valueOf(userIDStr);
            }

            // 查询获得内容对象
            CmsContent content = contentService.getContent(Integer.valueOf(contentID), userID);
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
            List<String> optionList = new ArrayList<String>();
            optionList.add(request.getServletPath().substring(1));
            optionList.add("content/" + content.getContentID());
            int pvCount = content.getPageViewCount() + 1;
            int uvCount = hisOperatorService.getUVCount(TableName.CMS_CONTENT.toString(), content.getContentID(), optionList);
            contentService.updateViewCount(content.getContentID(), pvCount, uvCount);
            content.setPageViewCount(pvCount);
            content.setUniqueVisitorCount(uvCount);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
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

                // 设置是否收藏的FavoriteID
                String userIDStr = request.getParameter("userID");
                if (StringUtil.isNotBlank(userIDStr) && ValidateUtil.isNumber(userIDStr)) {
                    List<CmsFavorite> cmsFavorites = favoriteService.getFavoriteList(Integer.parseInt(userIDStr));
                    // Key: ContentID, Value: FavoriteID
                    Map<Integer, Integer> favoriteIDMap = new HashMap<Integer, Integer>();
                    for (CmsFavorite item : cmsFavorites) {
                        favoriteIDMap.put(item.getContentID(), item.getFavoriteID());
                    }

                    for (CmsContent item : contentList) {
                        if (favoriteIDMap.containsKey(item.getContentID())) {
                            item.setFavoriteID(favoriteIDMap.get(item.getContentID()).toString());
                        }
                    }
                }
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(contentList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = { "/createContent", "/admin/createContent" }, method = RequestMethod.POST)
    public ResponseResult createContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String channelIDStr = request.getParameter("channelID");
            String userIDStr = request.getParameter("userID");
            String contentType = request.getParameter("contentType");

            result.checkFieldRequired("channelID", channelIDStr);
            result.checkFieldInteger("channelID", channelIDStr);
            result.checkFieldRequired("userID", userIDStr);
            result.checkFieldInteger("userID", userIDStr);
            result.checkFieldRequired("contentType", contentType);
            result.checkFieldInteger("contentType", contentType);

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            int channelID = Integer.parseInt(channelIDStr);
            Integer userID = Integer.parseInt(userIDStr);

         // 判断用户是否可以创建评论IsSlient＝1
            SecurityUser userInfo = sercurityUserService.getSecurityUserByID(userID);
            if (userInfo == null || userInfo.getIsSilent() != 0 || userInfo.getIsDisable() != 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.ConfinedFailed.getCode());
                Message message = new Message(MessageType.IsSlient.getCode(), MessageLevel.WARN, "SecurityUserInfo.IsSlient");
                result.getMessages().add(message);
                return result;
            }
            
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
            String startShowDate = request.getParameter("startShowDate");
            String startShowTime = request.getParameter("startShowTime");
            String endShowDate = request.getParameter("endShowDate");
            String endShowTime = request.getParameter("endShowTime");
            String pictureListStr = request.getParameter("pictureList");
            String status = request.getParameter("status");

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

            if (DateUtil.isFormat(startShowDate, DateUtil.DATE_HYPHEN)) {
                content.setStartShowDate(startShowDate);
            } else if (DateUtil.isFormat(startShowDate, DateUtil.DATE_TIME_HYPHEN)) {
                content.setStartShowDate(DateUtil.format(startShowDate, DateUtil.DATE_TIME_HYPHEN, DateUtil.DATE_HYPHEN));
            }
            if (DateUtil.isFormat(startShowTime, DateUtil.TIME_COLON)) {
                content.setStartShowTime(startShowTime);
            } else if (DateUtil.isFormat(startShowTime, DateUtil.DATE_TIME_HYPHEN)) {
                content.setStartShowTime(DateUtil.format(startShowTime, DateUtil.DATE_TIME_HYPHEN, DateUtil.TIME_COLON));
            }
            if (DateUtil.isFormat(endShowDate, DateUtil.DATE_HYPHEN)) {
                content.setEndShowDate(endShowDate);
            } else if (DateUtil.isFormat(endShowDate, DateUtil.DATE_TIME_HYPHEN)) {
                content.setEndShowDate(DateUtil.format(endShowDate, DateUtil.DATE_TIME_HYPHEN, DateUtil.DATE_HYPHEN));
            }
            if (DateUtil.isFormat(endShowTime, DateUtil.TIME_COLON)) {
                content.setEndShowTime(endShowTime);
            } else if (DateUtil.isFormat(endShowTime, DateUtil.DATE_TIME_HYPHEN)) {
                content.setEndShowTime(DateUtil.format(endShowTime, DateUtil.DATE_TIME_HYPHEN, DateUtil.TIME_COLON));
            }

            if (StringUtil.isNotBlank(status) && ValidateUtil.isNumber(status)) {
                content.setStatus(status);
            } else {
                content.setStatus("0");
            }

            content.setRemarks(remarks);
            content.setCreateTime(new Date());
            content.setCreateUserID(userID);
            content.setUpdateTime(new Date());
            content.setUpdateUserID(userID);

            if (StringUtil.isNotBlank(pictureListStr)) {
                JSONArray jsonArray = JSONArray.fromObject(pictureListStr);
                for (Object object : jsonArray) {
                    String pictureURL = object.toString();
                    String pictureName = FileUtil.getFileName(pictureURL);
                    CmsPicture picture = new CmsPicture();
                    picture.setPictureName(pictureName);
                    picture.setPictureURL(pictureURL);
                    content.getPictureList().add(picture);
                }
            }

            // 5秒内存在同样的数据，视为重复
            CmsContent existContent = contentService.getContentByInfo(userID, contentType, contentBody);
            if (existContent != null && DateUtil.subtract(new Date(), existContent.getCreateTime()) <= 30) {
                content = existContent;
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(content);
            } else {
                if (contentService.createContent(content)) {
                    content = contentService.getContent(content.getContentID());
                    result.setStatus(ResponseStatus.OK.getCode());
                    result.setData(content);
                    // 更新浏览记录
                    hisOperatorService.createHisOperator(TableName.CMS_CONTENT.toString(), content.getContentID(), request);
                } else {
                    result.setStatus(ResponseStatus.InsertFailed.getCode());
                }
            }          

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = { "/admin/updateContent" }, method = RequestMethod.POST)
    public ResponseResult updateContent(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String contentIDStr = request.getParameter("contentID");
            String channelIDStr = request.getParameter("channelID");
            String userIDStr = request.getParameter("userID");
            String contentType = request.getParameter("contentType");

            if (StringUtil.isBlank(contentIDStr)) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
            } else if (!ValidateUtil.isNumber(contentIDStr)) {
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "contentID");
                result.getMessages().add(message);
            }

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

            int contentID = Integer.parseInt(contentIDStr);
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
            String startShowDate = request.getParameter("startShowDate");
            String startShowTime = request.getParameter("startShowTime");
            String endShowDate = request.getParameter("endShowDate");
            String endShowTime = request.getParameter("endShowTime");
            String pictureListStr = request.getParameter("pictureList");
            String status = request.getParameter("status");

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
            content.setContentID(contentID);
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

            if (DateUtil.isFormat(startShowDate, DateUtil.DATE_HYPHEN)) {
                content.setStartShowDate(startShowDate);
            } else if (DateUtil.isFormat(startShowDate, DateUtil.DATE_TIME_HYPHEN)) {
                content.setStartShowDate(DateUtil.format(startShowDate, DateUtil.DATE_TIME_HYPHEN, DateUtil.DATE_HYPHEN));
            }
            if (DateUtil.isFormat(startShowTime, DateUtil.TIME_COLON)) {
                content.setStartShowTime(startShowTime);
            } else if (DateUtil.isFormat(startShowTime, DateUtil.DATE_TIME_HYPHEN)) {
                content.setStartShowTime(DateUtil.format(startShowTime, DateUtil.DATE_TIME_HYPHEN, DateUtil.TIME_COLON));
            }
            if (DateUtil.isFormat(endShowDate, DateUtil.DATE_HYPHEN)) {
                content.setEndShowDate(endShowDate);
            } else if (DateUtil.isFormat(endShowDate, DateUtil.DATE_TIME_HYPHEN)) {
                content.setEndShowDate(DateUtil.format(endShowDate, DateUtil.DATE_TIME_HYPHEN, DateUtil.DATE_HYPHEN));
            }
            if (DateUtil.isFormat(endShowTime, DateUtil.TIME_COLON)) {
                content.setEndShowTime(endShowTime);
            } else if (DateUtil.isFormat(endShowTime, DateUtil.DATE_TIME_HYPHEN)) {
                content.setEndShowTime(DateUtil.format(endShowTime, DateUtil.DATE_TIME_HYPHEN, DateUtil.TIME_COLON));
            }

            if (StringUtil.isNotBlank(status) && ValidateUtil.isNumber(status)) {
                content.setStatus(status);
            }

            content.setRemarks(remarks);
            content.setUpdateTime(new Date());
            content.setUpdateUserID(userID);

            boolean isPicutureListUpdate = false;
            if (StringUtil.isNotBlank(pictureListStr)) {
                JSONArray jsonArray = JSONArray.fromObject(pictureListStr);
                for (Object object : jsonArray) {
                    String pictureURL = object.toString();
                    String pictureName = FileUtil.getFileName(pictureURL);
                    CmsPicture picture = new CmsPicture();
                    picture.setPictureName(pictureName);
                    picture.setPictureURL(pictureURL);
                    content.getPictureList().add(picture);
                }
                isPicutureListUpdate = true;
            }

            if (contentService.updateContent(content, isPicutureListUpdate)) {
                content = contentService.getContent(content.getContentID());
            }

            if (content == null) {
                result.setStatus(ResponseStatus.UpdateFailed.getCode());
            } else {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData(content);
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.CMS_CONTENT.toString(), content.getContentID(), request);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            result.checkException(e);
        }
        return result;
    }
}
