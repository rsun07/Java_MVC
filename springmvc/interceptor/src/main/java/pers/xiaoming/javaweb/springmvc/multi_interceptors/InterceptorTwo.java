package pers.xiaoming.javaweb.springmvc.multi_interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// See tests and results in multi-interceptor.html
@Slf4j
public class InterceptorTwo implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Executing Interceptor Two ------ preHandle() ---");
        Boolean pass = Boolean.valueOf(request.getParameter("pass_two"));
        return pass;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Executing MyInterceptor Two ------ postHandle() ---");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Executing Interceptor Two ------ afterCompletion() ---");
    }
}
