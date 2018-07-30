package pers.xiaoming.javaweb.springmvc.multi_interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// See tests and results in multi-interceptor.html
@Slf4j
public class InterceptorOne implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Executing Interceptor One ------ preHandle() ---");
        Boolean pass = Boolean.valueOf(request.getParameter("pass_one"));
        return pass;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Executing Interceptor One ------ postHandle() ---");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Executing Interceptor One ------ afterCompletion() ---");
    }
}
