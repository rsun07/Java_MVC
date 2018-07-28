package pers.xiaoming.javaweb.springmvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/annotation/")
public class MyController {

    @RequestMapping(value = "/doFirst.do", method = RequestMethod.GET)
    public ModelAndView doFirst(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 28-Jul-2018 09:47:52.422 WARNING [http-nio-8080-exec-5] org.springframework.web.servlet.PageNotFound.noHandlerFound
        // No mapping found for HTTP request with URI [/annotation/springmvc-config.html] in DispatcherServlet with name 'dispatcher'
        // modelAndView.setViewName("springmvc-config.html");

        modelAndView.setView(new MyView());


        log.info("Executing MyController doFirst, request is {}", httpServletRequest.toString());

        return modelAndView;
    }
}
