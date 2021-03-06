package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(
		urlPatterns = { "/servlet12pluralUpdate" }, 
		initParams = { 
				@WebInitParam(name = "servlet12pluralUpdate", value = "123", description = "123")
		})
public class servlet12pluralUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//取得context域的位置路徑
		String uploadpath = getServletContext().getInitParameter("upload-path");
		//因有多個檔案上傳所以用getParts(),回傳集合一一取出
		Collection<Part> parts = request.getParts();
		
		for(Part part:parts) {
			String header = part.getHeader("Content-Disposition");
			String filename = servletAPI.getHeaderFileName(header);
			//防止沒有檔案上傳時
			if(filename!=null && filename.length()>0) {
				part.write(uploadpath + "/" + filename);
			}			
		}
	
	}
}





