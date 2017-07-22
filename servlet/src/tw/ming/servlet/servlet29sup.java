package tw.ming.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet29sup")
public class servlet29sup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		//ServletContext代表全體上下文,屬於application區域
		System.out.println(servletContext.getAttribute("x"));
		if(servletContext.getAttribute("x")!=null) {
			servletContext.removeAttribute("x");
		}
		System.out.println(servletContext.getAttribute("x"));
		
		System.out.println(servletContext.getAttribute("c"));
		if(servletContext.getAttribute("c")!=null) {
			servletContext.removeAttribute("c");
		}
		System.out.println(servletContext.getAttribute("c"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
