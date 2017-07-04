package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet13
 */
@WebServlet("/servlet13")
public class servlet13DispatcherTo1415 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//附加參數到servlet14
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet14?name=ming&status=ok");
		//附加參數到servlet15
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("servlet15?name=ming02&status=ok");

		
		out.println("<h1>Ming big company</h1>");
		out.println("<hr/>");
		
		//include
		dispatcher.include(request, response);
		out.println("<hr/>");
		dispatcher2.include(request, response);
		out.println("<hr/>");
		out.println("Copyright");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
