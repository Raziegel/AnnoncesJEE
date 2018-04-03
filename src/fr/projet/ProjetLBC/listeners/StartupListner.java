package fr.projet.ProjetLBC.listeners;

import javax.management.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.projet.ProjetLBC.jmx.Premier;
import fr.projet.ProjetLBC.jmx.LoggerJMX;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener()
public class StartupListner implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger logger = LogManager.getLogger(StartupListner.class);


    // Public constructor is required by servlet spec
    public StartupListner() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      logger.info("Démarrage de l'application");
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "127.0.0.1:9003";
            Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://" + url, "SA", "");
            logger.info("Démarrage BD ok");
            con.close();
        } catch (ClassNotFoundException e) {
            logger.error("Erreur au démarrage. Pas de driver", e);
        } catch (SQLException e) {
            logger.error("Erreur au démarrage. Problème de connexion", e);

        }
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = null;

        try {
            name = new ObjectName("fr.projet.ProjetLBC.jmx:type=LoggerJMXMBean");
            LoggerJMX mbean = new LoggerJMX();

            mbs.registerMBean(mbean, name);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e){
            e.printStackTrace();
        }catch (MBeanRegistrationException e){
            e.printStackTrace();
        }catch (NotCompliantMBeanException e){
            e.printStackTrace();
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
