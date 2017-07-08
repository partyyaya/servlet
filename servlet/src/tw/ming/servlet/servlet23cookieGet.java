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
		
		//接收cookie參數
		Cookie[] cookies = request.getCookies();
		//使用HashMap存放cookie
		HashMap<String,String> map = new HashMap<>();
		if(cookies!=null) {			
			for(Cookie c:cookies ) {
				String name = c.getName();
				String value = c.getValue();
				//把cookie存入
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
		//若網頁存有此名子cookie時
		if(map.containsKey("remember")) {
			//若使用者設為可以被觀看
			if(map.get("remember").equals("true")) {
				//則列印出他人帳號與密碼
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
