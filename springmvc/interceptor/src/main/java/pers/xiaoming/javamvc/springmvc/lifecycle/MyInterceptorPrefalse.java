package pers.xiaoming.javamvc.springmvc.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
INFO  p.x.j.s.c.l.a.MyInterceptorPrefalse - Executing MyInterceptor ------ preHandle() ---
 */
@Slf4j
public class MyInterceptorPrefalse implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Executing MyInterceptor ------ preHandle() ---");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Executing MyInterceptor ------ postHandle() ---");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Executing MyInterceptor ------ afterCompletion() ---");
    }
}
