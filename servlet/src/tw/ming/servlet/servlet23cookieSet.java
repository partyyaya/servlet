package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet23cookieSet")
public class servlet23cookieSet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//設一個cookie:name:ming
		Cookie cookieAccount = new Cookie("account","ming");
		//設定cookie生命存放時間(秒)
		cookieAccount.setMaxAge(1*60);
		response.addCookie(cookieAccount);
		
		
		Cookie cookieRemember = new Cookie("remember","true");
		//設定cookie生命存放時間(秒)
		cookieRemember.setMaxAge(1*60);
		response.addCookie(cookieRemember);
		
		
		Cookie cookiePasswd = new Cookie("passwd","123456");
		//設定cookie生命存放時間(秒)
		cookiePasswd.setMaxAge(1*60);
		response.addCookie(cookiePasswd);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
