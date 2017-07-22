package tw.ming.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class servlet30to29to31sup implements ServletContextListener {
	ServletContext servletContext;
	Timer timer;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//to29
		System.out.println("init");
		servletContext= event.getServletContext();
		servletContext.setAttribute("c", "234");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ming","root","root");
			servletContext.setAttribute("conn", conn);
			servletContext.setAttribute("isConnection",true);
		} catch (Exception e) {
			servletContext.setAttribute("isConnection",false);
			System.out.println("xx");
		}
		
		 timer = new Timer();
		 //(計時器,延遲一秒,以一秒為周期)>>每一秒延遲一秒
		 timer.schedule(new Mytask(), 1*1000, 1*1000);
	} 
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("destroy");
		//to31
		if ((Boolean)(servletContext.getAttribute("isConnection")) &&
				servletContext.getAttribute("conn") != null) {
			Connection conn = (Connection)servletContext.getAttribute("conn");
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("MySQL Close Error!");
			}
		}
		if (timer != null) {
			timer.cancel();
			timer.purge();
			timer = null;
		}
	}

}

class Mytask extends TimerTask{
	@Override
	public void run() {
		System.out.println("TimerTask");
	}
}
