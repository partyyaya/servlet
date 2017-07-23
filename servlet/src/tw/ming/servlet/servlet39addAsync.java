package tw.ming.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/servlet39addAsync",asyncSupported=true)
public class servlet39addAsync extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		
		//servlet39ServerListener:
		//servletContext.setAttribute("asyncs", asyncs);
		//servletContext.setAttribute("asyncListener", myAsyncListener);
		List<AsyncContext> asyncs=(List<AsyncContext>) servletContext.getAttribute("asyncs");
		servlet41AsyncListener asyncListner =  (servlet41AsyncListener)servletContext.getAttribute("asyncListener");
		System.out.println(asyncs);
		
		//將送來的要求一一存放於集合,為了避免同時使用synchronized
		synchronized (asyncs) {
			AsyncContext async = request.startAsync();
			async.addListener(asyncListner);
			async.getTimeout();
			asyncs.add(async);
			
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
