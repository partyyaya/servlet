package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class servlet11
 */
@WebServlet("/servlet11")
@MultipartConfig
public class servlet11singleUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String uploadpath = getServletContext().getInitParameter("upload");
		Part part = request.getPart("upload");
		String header = part.getHeader("Content-Disposition");
		
		out.print(header + "<br>");
		out.print(servletAPI.getHeaderFileName(header));
		
		String filename = part.getSubmittedFileName();
		part.write(uploadpath + "/" + filename);
		
//		out.print(uploadPath + "<br>");
//		out.print(filename + "<br>");
//		out.print("Upload Success");
	}

}
