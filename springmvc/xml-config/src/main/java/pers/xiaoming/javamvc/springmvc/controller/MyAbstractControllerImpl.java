package pers.xiaoming.javamvc.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyAbstractControllerImpl extends AbstractController {

    // Pay attention to the method name, which is different to the method name in MyController
    // This handler use template design pattern, here defines the abstract step method
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("abstractcontroller.html");

        log.info("Executing MyAbstractControllerImpl, request is {}", request.toString());

        return modelAndView;
    }
}
