/**
 * Copyright 2014-2015 IIDOOO All rights reserved.
 * Author(e-mail)   wangyixian@iidooo.com
 * Creation date    2015-03-26
 */
package com.iidooo.passport.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.iidooo.core.constant.CoreConstants;
import com.iidooo.passport.constant.PassportConstant;

/**
 * The sso filter for other web application. <br/>
 * This filter should be exported as jar package, then the other web application shoule defined it in web.xml
 * 
 * @author Ethan
 * 
 */
public class SSOFilter implements Filter {

    private static final Logger logger = Logger.getLogger(SSOFilter.class);


    private FilterConfig filterConfig;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            HttpSession session = httpRequest.getSession();

            // If has not login, redirect to SSO URL.
            if (!this.isLogined(httpRequest, session)) {

                // Set the Redirect URL after login.
                String url = httpRequest.getRequestURI();
                String parameters = httpRequest.getQueryString();
                if (parameters != null && !parameters.equals("")) {
                    url = url + "?" + parameters;
                }
                Cookie cookiesURL = new Cookie(PassportConstant.ACCESS_URL, url);
                cookiesURL.setPath("/");
                // - value mean the cookie will be delete when browse closed.
                cookiesURL.setMaxAge(-1);
                httpResponse.addCookie(cookiesURL);

                String ssourl = filterConfig.getInitParameter(PassportConstant.PASSPORT_URL);
                httpResponse.sendRedirect(ssourl);
                return;
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    private boolean isLogined(HttpServletRequest request, HttpSession session) {
        try {

            boolean result = false;

            // Check the cookies has USER_ID or not.
            // If has not this key, should redirect to SSO URL to login.
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(PassportConstant.LOGIN_ID)) {
                        session.setAttribute(PassportConstant.LOGIN_ID, cookie.getValue());
                        result = true;
                    } else if (cookie.getName().equals(PassportConstant.USER_ID)) {
                        session.setAttribute(PassportConstant.USER_ID, Integer.parseInt(cookie.getValue()));
                    } else if (cookie.getName().equals(PassportConstant.USER_NAME)) {
                        String userName = URLDecoder.decode(cookie.getValue(), CoreConstants.ENCODING_UTF8);
                        session.setAttribute(PassportConstant.USER_NAME, userName);
                    }
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

}
