package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("Context class in Context Listener : " + context.getClass());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
