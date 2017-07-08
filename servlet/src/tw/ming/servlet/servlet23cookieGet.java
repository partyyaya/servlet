package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet23cookieGet")
public class servlet23cookieGet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account="",passwd="";
		boolean isRemember=false;
		
		Cookie[] cookies = request.getCookies();
		HashMap<String,String> map = new HashMap<>();
		if(cookies!=null) {			
			for(Cookie c:cookies ) {
				String name = c.getName();
				String value = c.getValue();
				map.put(name, value);
//				out.print(c.getName()+":"+c.getValue()+"<br/>");
//				
//				if(c.getName().equals("remember")&& c.getValue().equals("true")) {
//					isRemember=true;
//				}
//				if(c.getName().equals("account")) {
//					account=c.getValue();			
//				}
//				if(c.getName().equals("passwd")) {
//					passwd=c.getValue();
//				}
				
			}
		}
		if(map.containsKey("remember")) {
			if(map.get("remember").equals("true")) {
				out.print(map.get("account")+":"+map.get("passwd")+"<br/>");
			}
			else {
				out.print("no account");
			}
		}
		else {
			out.print("no cookie");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
