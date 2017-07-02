package tw.ming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet09")
public class servlet09 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gender = request.getParameter("gender");
		//複選框選擇,需用陣列
		String[] hobby = request.getParameterValues("hobby");
		response.setContentType("text/html;charset=utf-8"); 
//		for(int i=0;i<hobby.length;i++){			
//		response.getWriter().write(hobby[i]);
//		}
		StringBuffer sb = new StringBuffer();
		for(String h:hobby){
			sb.append(h+"\n");
		}
		response.getWriter().write(sb.toString());
	}
}
