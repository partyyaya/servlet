package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet19AddAcount")
public class servlet19AddAcount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		
		out.println("<form>");
		out.println("Account: <input name='account'/><br/>");
		out.println("Password: <input type='password' name='passwd'/><br/>");
		out.println("<input type='submit' value='Add'/>");
		out.println("</form>");
		if(account!=null){
			addAcount(account, passwd);
			response.sendRedirect("servlet19main");
		}
		
	}	
	private void addAcount(String account ,String passwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user","root");
			prop.setProperty("password","root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ming",prop);
			String sql="insert into customer(account,passwd) VALUES(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//產生密碼亂碼
			String salt = BCrypt.gensalt(12);
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, salt));			
			pstmt.executeUpdate();
		
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
