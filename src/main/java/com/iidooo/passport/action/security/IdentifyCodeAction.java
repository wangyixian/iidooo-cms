package com.iidooo.passport.action.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.IdentifyCodeUtil;

public class IdentifyCodeAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(IdentifyCodeAction.class);

    public void init() {
        try {
            HttpServletResponse response = this.getResponse();
            HttpServletRequest request = this.getRequest();
            // 设置响应的类型格式为图片格式
            response.setContentType("image/jpeg");
            // 禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            HttpSession session = request.getSession();

            IdentifyCodeUtil vCode = new IdentifyCodeUtil(120, 40, 4, 100);
            session.setAttribute("code", vCode.getCode());
            vCode.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
