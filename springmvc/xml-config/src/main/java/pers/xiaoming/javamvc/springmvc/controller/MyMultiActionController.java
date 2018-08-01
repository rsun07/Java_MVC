package pers.xiaoming.javamvc.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import pers.xiaoming.javamvc.springmvc.exception.AgeException;
import pers.xiaoming.javamvc.springmvc.exception.NameException;
import pers.xiaoming.javamvc.springmvc.view.RegisterView;

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

    // Parameter pass in
    // And exception handling
    public ModelAndView doRegister(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 String name,
                                 int age) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        if (name == null) {
            throw new NameException("invalid name");
        }

        if (age <= 0 || age > 130) {
            throw new AgeException("invalid age");
        }

        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.setView(new RegisterView());

        log.info("Executing MyMultiActionController register Method, name is {}, age is {}", name, age);

        return modelAndView;
    }
}
