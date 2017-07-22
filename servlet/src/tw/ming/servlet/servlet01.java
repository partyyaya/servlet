package tw.ming.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet01")
public class servlet01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		System.out.println("doget");
		response.setContentType("text/html;charset=utf-8"); 
		try(PrintWriter writer = response.getWriter();){
		writer.write("hello world");
		writer.flush();
		}
	}
}
