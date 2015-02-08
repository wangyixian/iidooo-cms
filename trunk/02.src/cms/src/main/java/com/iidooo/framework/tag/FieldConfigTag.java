package com.iidooo.framework.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.dto.extend.FieldConfigDto;
import com.iidooo.framework.dto.extend.FieldDataDto;
import com.iidooo.framework.enumeration.BeanName;
import com.iidooo.framework.enumeration.FieldType;
import com.iidooo.framework.utility.SpringUtil;

public class FieldConfigTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(FieldConfigTag.class);

    // The submit to this name
    private String name;

    // The field configuration
    private List<FieldConfigDto> fieldConfigs;

    // The field data list
    private List<FieldDataDto> fieldDatas;

    int colspan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldConfigDto> getFieldConfigs() {
        return fieldConfigs;
    }

    public void setFieldConfigs(List<FieldConfigDto> fieldConfigs) {
        this.fieldConfigs = fieldConfigs;
    }

    public List<FieldDataDto> getFieldDatas() {
        return fieldDatas;
    }

    public void setFieldDatas(List<FieldDataDto> fieldDatas) {
        this.fieldDatas = fieldDatas;
    }

    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    @Override
    public void doTag() throws JspException, IOException {
        logger.debug("FieldConfigTag doTag method execute start.");
        PageContext pageContext = null;
        JspWriter out = null;
        try {

            if (fieldConfigs == null || fieldConfigs.size() <= 0) {
                logger.warn("There has not any field config to print out.");
                return;
            }

            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            // Key: FieldID
            // Value: FieldDataDto
            Map<Integer, FieldDataDto> fieldDataMap = new HashMap<Integer, FieldDataDto>();
            if (fieldDatas != null) {
                for (FieldDataDto item : fieldDatas) {
                    fieldDataMap.put(item.getFieldID(), item);
                }
            }

            DictItemDao dictItemDao = (DictItemDao) SpringUtil.getBean(pageContext.getServletContext(), BeanName.dictItemDao);

            int index = name.lastIndexOf(".");
            String namePrefix = name.substring(0, index);
            String nameSuffix = name.substring(index + 1);
            for (int i = 0 ; i < fieldConfigs.size(); i ++) {
                FieldConfigDto fieldConfig = fieldConfigs.get(i);
                out.println("<tr>");

                // Print out the field's title
                out.println("<th>");
                out.println(fieldConfig.getFieldTitle());
                out.println("</th>");

                out.println("<td colspan=" + colspan + ">");
                // Get FieldType by the Integer of fieldConfig.filedType
                FieldType fieldType = FieldType.values()[fieldConfig.getFieldType()];
                FieldDataDto fieldData = null;
                if (fieldDataMap.containsKey(fieldConfig.getFieldID())) {
                    fieldData = fieldDataMap.get(fieldConfig.getFieldID());
                }

                // The hidden value of FieldData.FieldID
                out.println("<input type='hidden' name='" + namePrefix + "[" + i + "].fieldID' value='" + fieldConfig.getFieldID() + "'>");
                switch (fieldType) {
                case Select:
                    String classCode = fieldConfig.getDictClassCode();
                    List<DictItemDto> dictItemDtos = dictItemDao.selectByClassCode(classCode);

                    out.println("<select name='" + namePrefix + "[" + i + "]." + nameSuffix + "'>");
                    for (DictItemDto item : dictItemDtos) {
                        if (fieldData == null) {
                            if (item.getIsDefault() >= 1) {
                                out.println("<option value='" + item.getDictItemCode() + "' selected='selected'>");
                            } else {
                                out.println("<option value='" + item.getDictItemCode() + "'>");
                            }
                        } else {
                            if (fieldData.getFieldValue().equals(item.getDictItemCode())) {
                                out.println("<option value='" + item.getDictItemCode() + "' selected='selected'>");
                            } else {
                                out.println("<option value='" + item.getDictItemCode() + "'>");
                            }
                        }
                        out.println(item.getDictItemName());
                        out.println("</option>");
                    }
                    out.println("</select>");
                    break;

                default:
                    break;
                }
                out.println("</td>");
                out.println("</tr>");
            }

            logger.debug("FieldConfigTag doTag method execute end.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            logger.warn("FieldConfigTag doTag method execute end with exception.");
        }
    }
}
