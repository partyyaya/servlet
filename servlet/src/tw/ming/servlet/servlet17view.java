package tw.ming.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet17view")
public class servlet17view extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//得到attribute
		String x = (String) request.getAttribute("x");
		String y = (String) request.getAttribute("y");
		Integer result = (Integer) request.getAttribute("result");
		//out.println(x+"+"+y+"="+result);

		//讀取template view
		//%s:欲輸入字串 		
		//將html全部換成字串
		String html = loadView("mycal.html");
		html =String.format(html,x,y,result);
		out.println(html);		
	}
	
	private String loadView(String file){
		String tempPath = getServletContext().getInitParameter("template-path");
		File viewFile = new File(tempPath,file);
		int len=(int)viewFile.length();
		byte[] buf = new byte[len];		
		try {
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(viewFile));
			bin.read(buf);
			bin.close();
		} catch (Exception e) {
			
		}			
		return new String(buf);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
