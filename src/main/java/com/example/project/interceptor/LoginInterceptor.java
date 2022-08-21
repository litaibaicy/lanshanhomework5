package com.example.project.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 登录检查
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /*
    目标方法执行之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}",requestURI);
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        if (loginUser != null){
            return true;
        }
        request.setAttribute("msg", "请先登录");
//        response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request, response);
        return  false;
    }
    /*
    目标方法执行完成后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);    }
    /*
    渲染页面以后
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);     }
}
