package com.iidooo.cms.controller;

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

import com.iidooo.cms.service.ContentService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.model.po.DictItem;
import com.iidooo.core.service.DictItemService;

@Controller
public class SystemController {
    private static final Logger logger = Logger.getLogger(SystemController.class);

    @Autowired
    private ContentService contentService;

    @Autowired
    private DictItemService dictItemService;

    @ResponseBody
    @RequestMapping(value = "/getInitData", method = RequestMethod.POST)
    public ResponseResult getInitData(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {

            int pvCount = contentService.getPVCountSum();

            List<DictItem> messageList = dictItemService.getDictItemsByClassCode("DICT_CLASS_CUSTOMIZED_MESSAGE");
            // 返回找到的内容对象
            result.setStatus(ResponseStatus.OK.getCode());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("PVSum", pvCount);
            for (DictItem item : messageList) {
                jsonObject.put(item.getDictItemCode(), item.getDictItemValue());
            }
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
}
