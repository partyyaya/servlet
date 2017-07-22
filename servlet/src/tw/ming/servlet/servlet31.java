package tw.ming.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet31")
public class servlet31 extends HttpServlet {
	private ServletContext servletContext;
	private Connection conn1, conn2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servletContext = getServletContext();
		try {
			conn1 = (Connection)servletContext.getAttribute("conn");
			Statement stmt = conn1.createStatement();
			stmt.executeUpdate("insert into member (account,passwd,realname) values ('aa','bb','cc')");
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn2 = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/ming",
					"root","root");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println(conn1 == conn2);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
