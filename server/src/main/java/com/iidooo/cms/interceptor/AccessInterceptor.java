package com.iidooo.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iidooo.cms.mapper.SecurityClientMapper;
import com.iidooo.core.util.StringUtil;

public class AccessInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger logger = Logger.getLogger(AccessInterceptor.class);

    @Autowired
    private SecurityClientMapper securityClientMapper;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String appID = request.getHeader("appID");
            String secret = request.getHeader("secret");
            
            if (StringUtil.isNotBlank(appID) && StringUtil.isNotBlank(secret)) {
                System.out.println("Access OK!");
            } else {
                System.out.println("Access Denied!");
            }
            
        } catch (Exception e) {
           logger.fatal(e);
        }
        return super.preHandle(request, response, handler);
    }

}
