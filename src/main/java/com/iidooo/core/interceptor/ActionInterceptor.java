package com.iidooo.core.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.iidooo.core.action.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ActionInterceptor extends AbstractInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * ActionInterceptor的Logger处理
     */
    private static final Logger logger = Logger.getLogger(ActionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {

            Object actionclass = invocation.getAction();

            if (actionclass instanceof BaseAction) {
                BaseAction baseAction = (BaseAction) actionclass;
                baseAction.setActionName(invocation.getProxy().getActionName());

                HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
                String uri = request.getRequestURI();
                String params = request.getQueryString();
                // Set the action's URL, the URL will be used when do page
                if (params == null || params.isEmpty()) {
                    baseAction.setActionUrl(uri);
                } else {
                    baseAction.setActionUrl(uri + "?" + params);
                }                
            }

            return invocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
