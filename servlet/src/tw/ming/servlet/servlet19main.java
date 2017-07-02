package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet19main")
public class servlet19main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user","root");
			prop.setProperty("password","root");			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ming",prop);
			
			//得到刪除的編號
			String delid = request.getParameter("delid");
			//進行刪除
			if(delid!=null) {
				conn.createStatement().executeUpdate("DELETE FROM customer WHERE id="+delid);
			}
			
			String sql="SELECT * from customer";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		out.println("<meta http-equiv=\"Content-Type\" content='text/html; charset=utf-8'>\r\n");
		out.println("<a href='servlet19AddAcount'>add</a>");
		out.println("<hr/>\r\n");
		out.println("<table border='1' width='100%'>\r\n" + 
				"<tr>\r\n" + 
				"<th>id</th>\r\n" + 
				"<td>account</td>\r\n" + 
				"<td>passwd</td>\r\n" + 
				"<td>delete</td>\r\n" +
				"</tr>\r\n"  
				);
		try {
			if(rs!=null) {				
					while(rs.next()) {
						String id = rs.getString("id");
						String account = rs.getString("account");
						out.print("<tr>");
						out.print("<td>"+id+"</td>");
						out.print("<td>"+rs.getString("account")+"</td>");
						out.print("<td>"+rs.getString("passwd")+"</td>");
						//判斷是否要刪除資料
						out.print("<td><a href='?delid=" + id + 
								"' onclick='return confirm(\"Delete " 
								+ account + "?\");'>Delete</a></td>");
						out.print("</tr>");					
					}
			}
		} catch (SQLException e) {
			
		}	
		out.println("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
