package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet40sqlMessage")
public class servlet40sqlMessage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mesg = request.getParameter("mesg");
		//40.ajax02,ajax0202一組
		// 更新資料庫訊息
		try {
			Connection conn = (Connection)getServletContext().getAttribute("conn");
			if (conn!=null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("insert into message (mesg) values ('" + mesg + "')");
			}
		}catch(Exception ee) {
			System.out.println(ee.toString());
		}
		
		// 發送
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		synchronized (asyncs) {
			for (AsyncContext asyncContext : asyncs) {
				System.out.println("send");
				
				HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print(mesg);
				asyncContext.complete();
			}
			asyncs.clear();
		};
		
		response.sendRedirect("ajax0202.html");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
