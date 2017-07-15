package tw.ming.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ming.javabeans.beanNumber;



@WebServlet("/controlServlet")
public class controlServlet extends HttpServlet {
	String randNumber =null ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int a = 0,b=0;
		String guessNumber = request.getParameter("guessNumber");
		String giveUp = request.getParameter("giveUp");
		if(randNumber ==null || giveUp!=null ) {
			randNumber =getRandNumber() ;
		}
		System.out.println(randNumber);
		beanNumber bean = new beanNumber();
		bean.setGuessNumber(guessNumber);
		bean.setRandNumber(randNumber);
		for(int i=0;i<randNumber.length();i++){
			if(randNumber.charAt(i) == guessNumber.charAt(i)) {
				a++;
				continue;
			}			
			for(int j=0;j<randNumber.length();j++) {
				if(guessNumber.charAt(i) == randNumber.charAt(j)) {
					b++;
				}
			}			
		}
		bean.setA(a);
		bean.setB(b);
		request.setAttribute("bean", bean);
		request.setAttribute("giveUp", giveUp);
		request.getRequestDispatcher("guess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	public String getRandNumber() {		
		int[] a=new int[4];
		int b;
		a[0]=(int)(Math.random()*10);
		for(int i=1;i<4;i++) {
			a[i]=(int)(Math.random()*10);
			for(int j=0;j<i;j++) {
				while(a[i]==a[j]) {
					a[i]=(int)(Math.random()*10);
				}
			}
		}
		b=a[0]*1000+a[1]*100+a[2]*10+a[3];
		return Integer.toString(b);
	}
}
