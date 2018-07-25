package pers.xiaoming.javaweb.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9090);
        server.setConnectors(new Connector[] { connector });

        // Jersey just use this resource config to produce servlets
        ContextHandler jerseyContextHandler = buildJerseyContextHandler();

        HandlerList handlers = new HandlerList();
        handlers.addHandler(jerseyContextHandler);
        server.setHandler(handlers);

        server.start();
        server.join();
    }

    private static ContextHandler buildJerseyContextHandler() {
        final ResourceConfig resourceConfig = new ResourceConfig();

        resourceConfig.packages("pers.xiaoming.javaweb.jetty.api");

        // servlet container is from jersey
        ServletContainer servletContainer = new ServletContainer(resourceConfig);

        // servlet holder is from eclipse jetty
        ServletHolder servletHolder = new ServletHolder(servletContainer);

        ServletContextHandler servletContextHandler = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        servletContextHandler.setSessionHandler(new SessionHandler());
        servletContextHandler.setContextPath("/");

        servletContextHandler.addServlet(servletHolder, "/*");

        return servletContextHandler;
    }
}
