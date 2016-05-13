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

import com.iidooo.cms.enums.TableName;
import com.iidooo.cms.model.vo.CmsContentWrap;
import com.iidooo.cms.service.FavoriteService;
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
public class FavoriteController {

    private static final Logger logger = Logger.getLogger(FavoriteController.class);

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @ResponseBody
    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
    public ResponseResult addFavorite(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
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

            int contentID = Integer.parseInt(contentIDStr);
            int userID = Integer.parseInt(userIDStr);

            Integer favoriteID = favoriteService.addFavorite(userID, contentID);
            if (favoriteID != null) {
                result.setStatus(ResponseStatus.OK.getCode());
                result.setData("success");
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.cms_favorite.toString(), favoriteID, request);
            } else {
                result.setStatus(ResponseStatus.InsertFailed.getCode());
                result.setData("failed");
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.toString());
            result.setStatus(ResponseStatus.Failed.getCode());
            result.getMessages().add(message);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/removeFavorite", method = RequestMethod.POST)
    public ResponseResult removeFavorite(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
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

            int contentID = Integer.parseInt(contentIDStr);
            int userID = Integer.parseInt(userIDStr);

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
            
            Integer favoriteID = favoriteService.removeFavorite(userID, contentID);
            if (favoriteID != null) {
                result.setStatus(ResponseStatus.OK.getCode());
                List<CmsContentWrap> contentWrapList = favoriteService.getFavoriteContentList(userID, page);
                result.setData(contentWrapList);
                // 更新浏览记录
                hisOperatorService.createHisOperator(TableName.cms_favorite.toString(), favoriteID, request);
            } else {
                result.setStatus(ResponseStatus.UpdateFailed.getCode());
                result.setData("failed");
            }

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.toString());
            result.setStatus(ResponseStatus.Failed.getCode());
            result.getMessages().add(message);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getFavoriteList", method = RequestMethod.POST)
    public ResponseResult getFavoriteList(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            // 解析获得传入的参数
            // 必填参数
            String userIDStr = request.getParameter("userID");
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

            int userID = Integer.parseInt(userIDStr);

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

            List<CmsContentWrap> contentWrapList = favoriteService.getFavoriteContentList(userID, page);
            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(contentWrapList);

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.toString());
            result.setStatus(ResponseStatus.Failed.getCode());
            result.getMessages().add(message);
        }
        return result;
    }
}
