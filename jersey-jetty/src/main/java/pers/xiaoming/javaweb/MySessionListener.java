package pers.xiaoming.javaweb;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session Class in Session Listener : " + session.getClass());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
