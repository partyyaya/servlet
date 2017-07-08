package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet26
 */
@WebServlet("/servlet26Thread")
public class servlet26Thread extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		out.print("ok");
		//若在外面則會先顯示,跑第二次才會跑出ok1~19
		new Thread(()->{	
			//若在裡面則跑第二次才會跑出okok1~19
			for(int i=0;i<20;i++) {
				out.println("OK"+i);
				System.out.println(i);
				try {
					Thread.sleep(500);//睡覺0.5秒
				} catch (InterruptedException e) {
					
				}
			}
		}).start();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
