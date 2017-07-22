package tw.ming.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class servlet3334SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session start"+new Date().toString());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("session destroy"+new Date().toString());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ming",
					"root","root");
			Statement stmt = conn.createStatement();
			
			HttpSession session = event.getSession();
			String ming = (String)session.getAttribute("mng");
			stmt.executeUpdate(
				"update member set islogin=0 where id=" +ming);
			
		}catch(Exception ee) {
			System.out.println(ee.toString());
		}
	}

}
