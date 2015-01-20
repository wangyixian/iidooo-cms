package com.iidooo.framework.interceptor;

import java.util.Map;

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
            return BaseAction.LOGIN;
        }
        return invocation.invoke();
    }
}
