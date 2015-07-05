package com.iidooo.passport.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import cn.co.sot.ehr.common.constants.AttributeConstants;
import cn.co.sot.sjf.dto.extender.SecurityResDto;

public class NavigationTag extends SimpleTagSupport{
	
	private static final Logger logger = Logger
			.getLogger(NavigationTag.class);

	private List<SecurityResDto> src;
	private String innerHtml;
	private SecurityResDto parent;
	
	public List<SecurityResDto> getSrc() {
		return src;
	}
	
	public void setSrc(List<SecurityResDto> src) {
		this.src = src;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		try {
			JspContext jspCtx = getJspContext();
			JspWriter out = jspCtx.getOut();
			out.println("<span>");
			out.print("当前位置：");
			innerHtml = "";
			buildTag(src);
			out.println(innerHtml);
			out.println("</span>");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage());
		}
	}
	private void buildTag(List<SecurityResDto> item){
		if(null == item || item.size() == 0){
			if(parent != null){
				if(!"".equals(innerHtml)){
					innerHtml += "-";
				}
				innerHtml += "<a style='color:black;'>";
				innerHtml += parent.getResourceName();
				innerHtml += "</a>";			
			}
			return;
		}
		for (SecurityResDto dto : item) {
			if(dto.getIsSelected()){
				if(parent != null){
					if(!"".equals(innerHtml)){
						innerHtml += "-";
					}
					innerHtml += "<a style='color:blue;TEXT-DECORATION: underline;'";
					innerHtml += " href='";
					innerHtml += parent.getResourceURL();
					innerHtml += "'>";
					innerHtml += parent.getResourceName();
					innerHtml += "</a>";			
				}
				parent = dto;
				buildTag(dto.getChildren());
				return;
			}
		}
		if(parent != null){
			if(!"".equals(innerHtml)){
				innerHtml += "-";
			}
			innerHtml += "<a style='color:black;'>";
			innerHtml += parent.getResourceName();
			innerHtml += "</a>";			
		}
		return;
	}



}
