package net.therap.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/12/12
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousAuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        if (request.getSession(false) != null && request.getSession().getAttribute("customer") != null) {
            response.sendRedirect("/BdHousingPortal/cus/home.htm");
            return false;
        }
        if (request.getSession(false) != null && request.getSession().getAttribute("flatowner") != null) {
            response.sendRedirect("/BdHousingPortal/own/home.htm");
            return false;
        }

        if (url.contains("/create") || url.contains("/logout") || url.contains("/delete")) {
            response.sendRedirect("/BdHousingPortal/app/login.htm");
            return false;
        }

        return true;
    }
}
