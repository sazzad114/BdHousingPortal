package net.therap.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatOwnerAuthInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession(false) == null || request.getSession().getAttribute("flatowner") == null) {
            response.sendRedirect("/BdHousingPortal/app/login.htm");
            return false;
        }
        return true;
    }
}
