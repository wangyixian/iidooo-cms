/**
 * Copyright 2014-2015 IIDOOO All rights reserved.
 * Author(e-mail)    wangyixian@iidooo.com
 * Creation date     2015-03-27
 */
package com.iidooo.passport.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.iidooo.core.action.BaseAPIAction;
import com.iidooo.core.action.BaseAction;
import com.iidooo.passport.action.IndexAction;
import com.iidooo.passport.action.LoginAction;
import com.iidooo.passport.constant.PassportConstant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * The interceptor of doing the authorization
 * @author Ethan
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
    
    @Override
    public final String intercept(final ActionInvocation invocation) throws Exception {
        try {
            Object actionclass = invocation.getAction();
            
            // The api action need this auth logic.
            if (actionclass instanceof BaseAPIAction) {
                return invocation.invoke();
            }
            
            // If the action class is LoginAction, need not check the session, just return.
            if (actionclass instanceof LoginAction) {
                return invocation.invoke();
            }
            
            Map<String, Object> session = ActionContext.getContext().getSession();
            if (session == null || !session.containsKey(PassportConstant.SECURITY_USER)) {
                return ActionSupport.LOGIN;
            }
            return invocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ActionSupport.ERROR;
        }
        
    }
}
