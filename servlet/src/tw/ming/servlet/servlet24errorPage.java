package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//在servers的server.xml可以改port
@WebServlet("/servlet24errorPage")
public class servlet24errorPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//double a=10,b=3;>>3.33333
		//double a=10,b=0;>>infinity
		//int a=10,b=3;>>3
		//int a=10,b=9;500(編號)報錯
		try {
		double a=10,b=3;
		out.print(a/b);
		}
		catch(Exception e) {
			//若發生錯誤,導出502頁面,假裝很忙
			response.sendError(HttpServletResponse.SC_BAD_GATEWAY,"server busy");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
