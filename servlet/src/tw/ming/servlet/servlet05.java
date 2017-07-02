package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.DocumentationTask;


@WebServlet("/servlet05")
public class servlet05 extends HttpServlet {  
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTask(request,response,"doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doTask(request,response,"doPost");
	}

	private void doTask(HttpServletRequest request, 
		HttpServletResponse response, String what) 
			throws ServletException, IOException {
		//設定回傳格式與編碼
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter pw =  response.getWriter();
		//取得所有標頭
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			//取出標頭裡面內容
			String value = request.getParameter(param);
			//輸出
			pw.write(param + " : " + value + "<br>");
		}
		
		pw.flush();
		pw.close();
	}
	
}
