package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * controler 
 * */

@WebServlet("/servlet17")
public class servlet17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//0.準備
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		if(x==null)x="0";
		if(y==null)y="0";
		
		//1.模型
		servlet17model model = new servlet17model(x, y);
		int result = model.add();
		
		//2.forward->view:引導到希望看到的地方
		//可用setAttribute傳物件
		request.setAttribute("x",x);
		request.setAttribute("y",y);
		request.setAttribute("result",result);
		request.getRequestDispatcher("servlet17view").forward(request, response);
		
		//3.輸入:servlet17?x=11&y=21 會到servlet17view顯示
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
