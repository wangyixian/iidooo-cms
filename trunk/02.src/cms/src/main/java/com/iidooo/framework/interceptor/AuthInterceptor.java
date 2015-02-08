package com.iidooo.framework.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iidooo.framework.action.LoginAction;
import com.iidooo.framework.action.BaseAction;
import com.iidooo.framework.constant.SessionConstant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public final String intercept(final ActionInvocation invocation) throws Exception {
        Object actionclass = invocation.getAction();

        if (actionclass instanceof LoginAction) {
            return invocation.invoke();
        }
        
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session == null || !session.containsKey(SessionConstant.SECURITY_USER)) {
            if (session == null) {
                session = new HashMap<String, Object>();
            }
            
            // Set the Redirect URL after login.
            HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
            String url = request.getRequestURI();
            String parameters = request.getQueryString();
            session.put(SessionConstant.REDIRECT_URL, url + "?" +parameters);
            ActionContext.getContext().setSession(session);
            return BaseAction.LOGIN;
        }
        return invocation.invoke();
    }
}
