package com.fiable.hellorest;
import com.fiable.service.RestEx;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
/**
 *
 * @author Thiyagaraja Kalidoss
 */
public class App {

    public static void main(String[] args) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", RestEx.class.getCanonicalName());
        try {
            jettyServer.start();
            // jettyServer.dumpStdErr();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                jettyServer.stop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}
