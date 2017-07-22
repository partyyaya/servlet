package tw.ming.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet34sqlSssionLogin")
public class servlet34sqlSssionLogin extends HttpServlet {
	 ServletContext context;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context=getServletContext();
		try {
			Connection conn = (Connection) context.getAttribute("conn");
			Statement stmt = conn.createStatement();	
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM member where account='ming' and isLogin=0");
			//判斷是否已登入
			if(rs.next()) {
				HttpSession session = request.getSession();
				stmt.executeUpdate("update member set isLogin=1 where account='ming'");
				session.setAttribute("mng", "1");
				session.setMaxInactiveInterval(60);
				System.out.println("new login");
			}else {
				//若在其他瀏覽器以登入,則無法再從其他瀏覽器登入相同帳號
				System.out.println("Login already");
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
