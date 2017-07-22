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
import javax.servlet.http.HttpSession;


@WebServlet("/servlet34sqlSssionLoginSup")
public class servlet34sqlSssionLoginSup extends HttpServlet {
	ServletContext context;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context=getServletContext();
		try {
			Connection conn = (Connection) context.getAttribute("conn");
			Statement stmt = conn.createStatement();	
			HttpSession session = request.getSession(false);
			if(session!=null) {
				String mng = (String) session.getAttribute("mng");
				stmt.executeUpdate("update member set isLogin=1 where id="+mng);
			}			
			System.out.println("ok2");
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
