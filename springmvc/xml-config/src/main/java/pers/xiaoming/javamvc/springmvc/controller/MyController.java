package pers.xiaoming.javamvc.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
// Controller is a kind of Handler
public class MyController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "Hello Spring MVC world");
        modelAndView.setViewName("springmvc-config.html");

        log.info("Executing MyController request is {}", httpServletRequest.toString());

        return null;
    }
}
