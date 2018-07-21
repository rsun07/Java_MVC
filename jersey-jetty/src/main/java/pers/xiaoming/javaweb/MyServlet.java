package pers.xiaoming.javaweb;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        log.info("Request Class in Servlet : " + request.getClass());
        log.info("Response Class in Servlet : " + response.getClass());
    }
}
