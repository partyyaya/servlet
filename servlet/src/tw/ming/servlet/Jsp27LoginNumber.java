package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ming.javabeans.Jsp27Member;

/**
 * Servlet implementation class Jsp27LoginNumber
 */
@WebServlet("/Jsp27LoginNumber")
public class Jsp27LoginNumber extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//1.prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		//2.model
		try {
			Jsp27Member member = new Jsp27Member();
			member.setAccount(account);
			member.setPasswd(passwd);
			if(member.isValidMember()) {
				
			}
		}catch(Exception e) {
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
