package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet39putAsync")
public class servlet39putAsync extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs=(List<AsyncContext>) servletContext.getAttribute("asyncs");
		
		synchronized (asyncs) {
			//將要求一一推撥出去,避免同時送出壅擠使用synchronized
			for(AsyncContext asyncContext : asyncs) {
				PrintWriter out = asyncContext.getResponse().getWriter();
				out.print("Message:"+(int)(Math.random()*49+1));
				asyncContext.complete();
			}
			asyncs.clear();//清除裡面資料
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
