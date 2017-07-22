package tw.ming.servlet;

import java.io.IOException;
import java.sql.Connection;
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
	private ServletContext servletContext=getServletContext();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection conn = (Connection) servletContext.getAttribute("conn");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO member (account,passwd,realname) values('aa','bb','cc')");
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
