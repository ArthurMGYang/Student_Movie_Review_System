package com.mao.smr.interceptor;

import com.mao.smr.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * the LoginInterceptor is used to intercept those users without logged in
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * if the user go to the index page which contains the whole one-page application
     * the user will be direct to login page
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception{
        HttpSession session = httpServletRequest.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = httpServletRequest.getRequestURI();
        uri = StringUtils.remove(uri, contextPath +"/");
        String page = uri;

        if(beginWith(page, requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if(user == null){
                httpServletResponse.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    public boolean beginWith(String page, String[] requiredAuthPages){
        boolean result = false;
        for(String requiredAuthPage : requiredAuthPages){
            if(StringUtils.startsWith(page, requiredAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }
}
