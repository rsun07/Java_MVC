package pers.xiaoming.javamvc.ssm.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// this is equivalent to the web.xml config to launch Tomcat
@Order(1)
public class MyWebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        // Create Spring ApplicationContext when ServletContext start
        // Equivalent to "org.springframework.web.context.ContextLoaderListener" in web.xml
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringAppConfig.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
