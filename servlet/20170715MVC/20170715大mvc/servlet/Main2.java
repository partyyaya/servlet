package tw.brad.j2ee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.brad.beans.MemberV2;

@WebServlet("/Main2")
public class Main2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if ( 	session.getAttribute("member") == null) {
			// View
			response.sendRedirect("Login");
		}else {
		System.out.println(((MemberV2)session.getAttribute("member")).getRealName());
		// View
			request.getRequestDispatcher("main2.jsp").forward(request, response);
		}
	}
}
