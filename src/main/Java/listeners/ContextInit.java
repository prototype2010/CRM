package listeners;

import database.DataService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
* Created by Boris on 07.05.2016.
*/
public class ContextInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataService service=new DataService();
        service.init();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
