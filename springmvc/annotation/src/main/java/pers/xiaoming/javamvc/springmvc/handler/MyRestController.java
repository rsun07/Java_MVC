package pers.xiaoming.javamvc.springmvc.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/annotation/rest")
public class MyRestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting() {
        return "hello world to rest controller";
    }
}
