package com.iidooo.framework.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.framework.service.DictItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The abstract of common base action
 * 
 * @author wangyixian
 * 
 */
public abstract class BaseAction extends ActionSupport {

	private static final Logger logger = Logger.getLogger(BaseAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 字典项处理的Service
     */
    @Autowired
    protected DictItemService dictItemService;
	
	/**
	 * 访问Action的URL，子类中需要给赋值
	 */
	private String actionUrl;

	/**
	 * 得到访问Action的URL
	 * 
	 * @return actionUrl
	 */
	public String getActionUrl() {
		return actionUrl;
	}

	/**
	 * 设置Action的URL
	 * 
	 * @param actionUrl
	 */
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	
    /**
     * 默认构造函数
     */
    public BaseAction() {
        logger.debug("The begin of the method Constructor");
        
        HttpServletRequest request = getRequest();
        String path = request.getServletPath();
        // 设置action的URL，该URL会在页面上使用，比如分页显示时
        if (path != null && !"".equals(path) && path.startsWith("/")) {
            this.actionUrl = path.substring(1);
        }
        
        logger.debug("The end of the method Constructor");
    }

	/**
	 * Get the session
	 * 
	 * @return Map<String, Object> session
	 */
	public Map<String, Object> getSession() {
		logger.debug("The begin of the method getSession");

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		logger.debug("The end of the method getSession");
		return session;
	}

	/**
	 * Get the HttpServletRequest
	 * 
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getRequest() {
		logger.debug("The begin of the method getRequest");

		HttpServletRequest request = ServletActionContext.getRequest();

		logger.debug("The end of the method getRequest");
		return request;
	}

	/**
	 * Get the HttpServletResponse
	 * 
	 * @return HttpServletResponse
	 */
	public HttpServletResponse getResponse() {
		logger.debug("The begin of the method getResponse");

		HttpServletResponse response = ServletActionContext.getResponse();

		logger.debug("The end of the method getResponse");
		return response;
	}
	
	public ServletContext getServletContext() {
	    ServletContext servletContext = ServletActionContext.getServletContext();
	    return servletContext;
    }
}
