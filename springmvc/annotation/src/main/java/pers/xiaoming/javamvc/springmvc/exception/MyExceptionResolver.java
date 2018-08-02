package pers.xiaoming.javamvc.springmvc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pers.xiaoming.javamvc.springmvc.view.exception.AgeExceptionView;
import pers.xiaoming.javamvc.springmvc.view.exception.DefaultErrorView;
import pers.xiaoming.javamvc.springmvc.view.exception.NameExceptionView;

public class MyExceptionResolver {

    @ExceptionHandler(NameException.class)
    public ModelAndView handleNameException(Exception ex) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("ex", ex);

        mv.setView(new NameExceptionView());

        return mv;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView handleAgeException(Exception ex) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("ex", ex);

        mv.setView(new AgeExceptionView());

        return mv;
    }

    @ExceptionHandler
    public ModelAndView handleOtherException(Exception ex) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("ex", ex);

        mv.setView(new DefaultErrorView());

        return mv;
    }
}
