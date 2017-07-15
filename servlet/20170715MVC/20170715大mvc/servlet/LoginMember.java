package tw.brad.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.brad.beans.MemberV2;

@WebServlet("/LoginMember")
public class LoginMember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		// 1. prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");

		// 2. Model
		try {
			MemberV2 member = new MemberV2();
			member.setAccount(account);
			member.setPasswd(passwd);
			
			if (member.isValidMember()) {
				// Login Success
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("Main2");
				
			}else {
				// Login Failure
				out.print("XX");
			}
			
		}catch(Exception e) {
			out.print("EE");
		}
		
		
		
		
		
		
	}

}
