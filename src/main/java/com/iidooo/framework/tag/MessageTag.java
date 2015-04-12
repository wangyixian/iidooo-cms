package com.iidooo.framework.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.framework.tag.component.Message;

public class MessageTag  extends SimpleTagSupport{
    
    private static final Logger logger = Logger.getLogger(MessageTag.class);
    
    private final String MESSAGE_CONTENT = "<span class='{0}'>{1}</span>";
    
    private Message message;
    
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = null;
        JspWriter out = null;
        try {

            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            out.println("<span>");
            
            out.println("</span>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
