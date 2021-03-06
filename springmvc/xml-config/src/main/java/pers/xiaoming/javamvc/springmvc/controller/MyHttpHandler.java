package pers.xiaoming.javamvc.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHttpHandler implements HttpRequestHandler {
    public void handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws ServletException, IOException {

        log.info("Executing MyHttpHandler, request is {}", httpServletRequest.toString());
        httpServletRequest.getRequestDispatcher("httphandler.html").forward(httpServletRequest, httpServletResponse);
    }
}
