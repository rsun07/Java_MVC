package pers.xiaoming.javamvc.springmvc.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class RegisterView implements View {

    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = (String) model.get("name");
        Object age = model.get("age");

        PrintWriter writer = response.getWriter();
        writer.printf("Register View executing, name is %s, age is %s", name, age);
    }
}
