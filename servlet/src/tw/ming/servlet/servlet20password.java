package tw.ming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet20password")
public class servlet20password extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salt = BCrypt.gensalt(12);
		//產生種子亂碼
		String newpasswd = BCrypt.hashpw("123456", salt);
		System.out.println(newpasswd);
		
		if(ckPasswd("123456", newpasswd)) {
			System.out.println("ok");
		}else {
			System.out.println("xx");
		}
	}
	private static boolean ckPasswd(String orgPasswd,String hashPasswd){
		boolean isRight=false;
		if(hashPasswd==null || hashPasswd.startsWith("$2a$")){
			isRight=false;
			
		}
		isRight=BCrypt.checkpw(orgPasswd, hashPasswd);
		return isRight;
	}

}
