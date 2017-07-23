package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class servlet36setRequestAttribute02
 */
@WebServlet("/servlet36setRequestAttribute02")
public class servlet36setRequestAttribute02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("x", "200");
		String str = (String) request.getAttribute("x");
		PrintWriter out = response.getWriter();
		out.print(str);
		request.removeAttribute("x");
		
		String str2 = (String) request.getAttribute("x");		
		out.print(str2);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
