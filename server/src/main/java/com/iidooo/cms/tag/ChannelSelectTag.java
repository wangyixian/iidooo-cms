package com.iidooo.cms.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.iidooo.cms.mapper.CmsChannelMapper;
import com.iidooo.cms.model.po.CmsChannel;
import com.iidooo.cms.util.ChannelUtil;
import com.iidooo.core.util.MybatisUtil;
import com.iidooo.core.util.StringUtil;

public class ChannelSelectTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelSelectTag.class);

    private final String HTML_SELECT = "<select id='{0}' name='{1}'>";

    private final String HTML_SELECT_DISABLED = "<select id='{0}' name='{1}' disabled='disabled'>";

    private final String HTML_OPTION = "<option value='{0}'>{1}</option>";

    private final String HTML_OPTION_SELECT = "<option value='{0}' selected='selected'>{1}</option>";

    private String id;

    private String name;

    private String value;

    private boolean isDiabled = false;

    private boolean isContainBlank = true;

    private int index = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getIsDiabled() {
        return isDiabled;
    }

    public void setIsDiabled(boolean isDiabled) {
        this.isDiabled = isDiabled;
    }

    public boolean getIsContainBlank() {
        return isContainBlank;
    }

    public void setIsContainBlank(boolean isContainBlank) {
        this.isContainBlank = isContainBlank;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            if (isDiabled) {
                out.println(StringUtil.replace(HTML_SELECT_DISABLED, id, name));
            } else {
                out.println(StringUtil.replace(HTML_SELECT, id, name));
            }

            if (isContainBlank) {
                out.println(StringUtil.replace(HTML_OPTION, "0", ""));
            }

            SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
            CmsChannelMapper channelDao = sqlSession.getMapper(CmsChannelMapper.class);

//            List<CmsChannel> channelList = channelDao.selectAllChannels();
//            ChannelUtil.counstructChildren(channelList);
//
//            if (channelList.size() > 0) {
//                for (CmsChannel item : channelList) {
//                    if (item.getParentID() <= 0) {
//                        printHTML(out, item);
//                    }
//                }
//            }

            out.println("</select>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void printHTML(JspWriter out, CmsChannel channelDto) throws JspException, IOException {
        try {
            String name = channelDto.getChannelName();
            for (int i = 0; i < index; i++) {
                name = "&nbsp;&nbsp;" + name;
            }
            if (value != null && !value.isEmpty() && value.equals(channelDto.getChannelID().toString())) {
                out.println(StringUtil.replace(HTML_OPTION_SELECT, channelDto.getChannelID().toString(), name));
            } else {
                out.println(StringUtil.replace(HTML_OPTION, channelDto.getChannelID().toString(), name));
            }

//            List<CmsChannel> children = channelDto.getChildren();
//            for (CmsChannel child : children) {
//                this.index++;
//                this.printHTML(out, child);
//                this.index--;
//            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
