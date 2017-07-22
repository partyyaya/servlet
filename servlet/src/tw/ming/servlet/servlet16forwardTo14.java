package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet16forwardTo14")
public class servlet16forwardTo14 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//行李箱多加參數到servlet14
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet14?name=ming&status=ok");
				
		out.println("<h1>Ming big company</h1>");
		out.println("<hr/>");
		
		//forward整個頁面轉過去
		dispatcher.forward(request, response);
		out.println("<hr/>");
		out.println("<hr/>");
		out.println("Copyright");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
