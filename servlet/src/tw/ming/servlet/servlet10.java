package tw.ming.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class servlet10
 */
@WebServlet("/servlet10")
@MultipartConfig
public class servlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter++;
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("upload");
		
		Collection<String> cc = part.getHeaderNames();
		for(String c:cc){
			String v = part.getHeader(c);
			out.println(c+"<br/>"+v+"<br/>");
		}
		String filename = part.getSubmittedFileName();
		out.print(filename+"\n"+"<br/>");
		String name = part.getName();
		long size = part.getSize();
		out.print(name+":"+size);
		
		//以下開始讀取資料
		byte[] buf=new byte[(int)size];
		
		ServletContext context = getServletContext();
//		Enumeration<String> names = context.getInitParameterNames();
//		while(names.hasMoreElements()){
//			String pname = names.nextElement();
//			out.println(pname+"="+context.getInitParameter(pname)+"<br/>");
//		}
		
		String uploadpath = context.getInitParameter("upload-path");
		FileOutputStream fout = new FileOutputStream(new File(uploadpath,filename));
		fout.write(buf);
		fout.flush();
		fout.close();
//--------------------------查詢文件的絕對位置是否存在------------------------------------------//
//		File here = new File("dir1");
//		out.print(":"+here.getAbsolutePath());
//		if(here.exists()){
//			out.print("ok"+"<br/>");
//		}else{
//			out.print("xx"+"<br/>");
//		}

//---------------------------------在網頁上讀取資料----------------------------------------//
//		BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
//		bin.read(buf);
//		bin.close();
//		out.print(new String(buf));
		
//-------------------------------使用絕對路徑添加檔案------------------------------//		
//		FileOutputStream fout = new FileOutputStream("C:\\Users\\Mac\\git_servlet\\servletJsp\\WebContent\\dir1\\"+filename);
//		fout.write(buf);
//		fout.flush();
//		fout.close();
		
//----------------------錯誤-------------------------//		
//		String type = request.getContentType();
//		int len = request.getContentLength();
//		String line;
//		BufferedReader br = request.getReader();
//		while((line=br.readLine())!=null){
//			out.println(line+"<br/>");
//		}
//		br.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doGet(req, resp);
	}
}
