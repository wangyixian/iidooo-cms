package com.iidooo.passport.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.ResourceDto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MenuInterceptor extends AbstractInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(MenuInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
            String path = request.getServletPath();

            ActionContext actionContext = invocation.getInvocationContext().getContext();
            Map<String, Object> application = actionContext.getApplication();
            Map<String, ResourceDto> securityResMap = (Map<String, ResourceDto>) application.get(PassportConstant.SESSION_RESOURCE_MAP);

            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            
            ResourceDto currentSecurityResDto = securityResMap.get(path);
            if (currentSecurityResDto == null) {
                logger.warn(request.getServletPath() + " is not contained in the system!");
                return invocation.invoke();
            }
            application.put(PassportConstant.SESSION_RESOURCE_CURRENT, currentSecurityResDto);
            
            List<ResourceDto> securityResList = (List<ResourceDto>) application.get(PassportConstant.SESSION_RESOURCE_LIST);
            // Set the parent resource selected
            for (ResourceDto item : securityResList) {
                item.setIsSelected(false);
                if (item.getResourceURL().equals(currentSecurityResDto.getResourceURL()) || 
                        item.equals(currentSecurityResDto) || item.getOffspring().contains(currentSecurityResDto)) {
                    item.setIsSelected(true);

                    if (item.getParentID() <= 0) {
                        request.setAttribute(PassportConstant.SESSION_RESOURCE_SELECTED_ITEM, item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return invocation.invoke();
    }

}
