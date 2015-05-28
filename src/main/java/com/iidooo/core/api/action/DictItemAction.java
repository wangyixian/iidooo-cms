package com.iidooo.core.api.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAPIAction;
import com.iidooo.core.api.service.IDictItemService;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dto.extend.DictItemDto;

public class DictItemAction extends BaseAPIAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(DictItemAction.class);

    @Autowired
    private IDictItemService dictItemService;

    public void dictItems() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String method = request.getMethod();
            switch (method) {
            case CoreConstants.HTTP_METHOD_GET:
                String dictClassCode = request.getParameter(CoreConstants.FIELD_DICT_CLASS_CODE);

                if (dictClassCode == null || dictClassCode.isEmpty()) {
                    return;
                }

                List<DictItemDto> dictItemList = dictItemService.getDictItemList(dictClassCode);


                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = JSONArray.fromObject(dictItemList);
                jsonObject.put(CoreConstants.FIELD_DICT_ITEM_LIST, jsonArray);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentType(CoreConstants.APPLICATION_JSON);
                response.setCharacterEncoding(CoreConstants.ENCODING_UTF8);
                PrintWriter writer = response.getWriter();
                writer.write(jsonObject.toString());
                writer.close();
                break;

            default:
                break;
            }
            // String json = IOUtils.toString(request.getInputStream());
            // if (json == null || json.isEmpty()) {
            // return;
            // }
            //
            // JSONObject jsonObject = JSONObject.fromObject(json);
            // String dictClassCode = jsonObject.getString(CoreConstants.FIELD_DICT_CLASS_CODE);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
