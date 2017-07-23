package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//asyncSupported:支援非同步,預設為false
@WebServlet(urlPatterns="/servlet3803",asyncSupported=true)
public class servlet3803 extends HttpServlet {
	//做pool裡面設10條執行
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	AsyncContext asyncContext;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//非同步的context
		 asyncContext = request.startAsync();
		//將做的事送上執行緒
		executorService.submit(new AsyncRequest());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void destroy() {
		//將service釋放
		executorService.shutdown();
		super.destroy();
	}
	
	private class AsyncRequest implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(15*1000);
				PrintWriter out = asyncContext.getResponse().getWriter();
				out.println("ok3:"+(int)(Math.random()*49+1));
				asyncContext.complete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
