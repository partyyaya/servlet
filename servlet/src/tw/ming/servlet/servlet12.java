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
		urlPatterns = { "/servlet12" }, 
		initParams = { 
				@WebInitParam(name = "servlet12", value = "123", description = "123")
		})
public class servlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String uploadpath = getServletContext().getInitParameter("upload-path");
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





