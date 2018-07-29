package pers.xiaoming.javaweb.springmvc.view.exception;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class DefaultErrorView implements View {

    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = (String) model.get("name");
        Object age = model.get("age");

        PrintWriter writer = response.getWriter();
        writer.printf("Default Error executing, name is %s, age is %s", name, age);

        response.setStatus(400);
    }
}
