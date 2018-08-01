package pers.xiaoming.javaweb.springmvc.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.xiaoming.javaweb.springmvc.exception.AgeException;
import pers.xiaoming.javaweb.springmvc.exception.MyExceptionResolver;
import pers.xiaoming.javaweb.springmvc.exception.NameException;
import pers.xiaoming.javaweb.springmvc.view.MyView;
import pers.xiaoming.javaweb.springmvc.view.RegisterView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/pers.xiaoming.springmvc.ssm.annotation/")
public class MyController extends MyExceptionResolver {

    @RequestMapping(value = "/doFirst.do", method = RequestMethod.GET)
    public ModelAndView doFirst(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 28-Jul-2018 09:47:52.422 WARNING [http-nio-8080-exec-5] org.springframework.web.servlet.PageNotFound.noHandlerFound
        // No mapping found for HTTP request with URI [/pers.xiaoming.springmvc.ssm.annotation/springmvc-config.html] in DispatcherServlet with name 'dispatcher'
        // modelAndView.setViewName("springmvc-config.html");

        modelAndView.setView(new MyView());


        log.info("Executing MyController doFirst, request is {}", httpServletRequest.toString());

        return modelAndView;
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ModelAndView register(
            // here parameter should be provided as Query parameter
            @RequestParam("user_name") String name,
            @RequestParam(value = "age", defaultValue = "0") int age
    ) throws Exception {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);

        if (name == null || name.trim().equals("")) {
            throw new NameException("invalid name");
        }

        if (age < 0 || age > 150) {
            throw new AgeException("invalid age");
        }

        modelAndView.setView(new RegisterView());


        log.info("Executing MyController register, name is {}, age is {}", name, age);

        return modelAndView;
    }
}
