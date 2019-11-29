import com.dao.impl.DaoImpl;
import com.dao.interf.DaoInterface;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ContestListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private DaoInterface dao;
    // Public constructor is required by servlet spec
    public ContestListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

      dao=new DaoImpl();
        try {
            dao.createConn();
            System.out.println("----------c3p0创建数据库连接初始化----------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sce.getServletContext().setAttribute("dao",dao);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
      dao=null;
    }
}
