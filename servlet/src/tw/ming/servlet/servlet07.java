package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet07")
public class servlet07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//request取得html數值後再response
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int result = x + y;
		System.out.println(result);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//不能直接放入int,因為會轉字元碼:65=A
		pw.write(x + " + " + y + " = " + result);
//		pw.write(97);
		pw.flush();
		pw.close();
	}
}
