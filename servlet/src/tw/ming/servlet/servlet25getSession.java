package tw.ming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet25getSession")
public class servlet25getSession extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//若沒有已存在session,就會自動新創立一個
		HttpSession session = request.getSession();
		
		//true:跟上面依樣:沒有已存在session,就會自動新創立一個
		HttpSession session2 = request.getSession(true);
		
		//false:若使用者沒有session則把他趕走
		HttpSession session3 = request.getSession(false);
		
		servlet25member member = new servlet25member("ming", 24);
		//可存放物件
		session.setAttribute("who",member);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
