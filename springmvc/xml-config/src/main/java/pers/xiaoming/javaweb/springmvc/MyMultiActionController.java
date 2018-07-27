package pers.xiaoming.javaweb.springmvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyMultiActionController extends MultiActionController {
    public ModelAndView doFirst(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("multi-action-do-first.html");

        log.info("Executing MyMultiActionController doFirst Method, request is {}", httpServletRequest.toString());

        return modelAndView;
    }

    public ModelAndView doSecond(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("multi-action-do-second.html");

        log.info("Executing MyMultiActionController doSecond Method, request is {}", httpServletRequest.toString());

        return modelAndView;
    }
}
