package pers.xiaoming.javaweb.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("ex", ex);

        mv.setViewName("error/default-error.html");

        if (ex instanceof NameException) {
            mv.setViewName("error/invalid-name-exception");
        }

        if (ex instanceof AgeException) {
            mv.setViewName("error/invalid-age-exception");
        }

        return mv;
    }
}
