package pers.xiaoming.javamvc.springmvc.interceptor_filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
INFO  p.x.j.s.interceptor_filter.MyFilter - Executing MyFilter Before Controller
INFO  p.x.j.s.i.MyInterceptorCopy - Executing MyInterceptor ------ preHandle() ---
INFO  p.x.j.s.controller.MyController - Executing MyController
INFO  p.x.j.s.i.MyInterceptorCopy - Executing MyInterceptor ------ postHandle() ---
INFO  p.x.j.s.i.MyInterceptorCopy - Executing MyInterceptor ------ afterCompletion() ---
INFO  p.x.j.s.interceptor_filter.MyFilter - Executing MyFilter After Controller
 */

@Slf4j
public class MyInterceptorCopy implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Executing MyInterceptor ------ preHandle() ---");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Executing MyInterceptor ------ postHandle() ---");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Executing MyInterceptor ------ afterCompletion() ---");
    }
}
