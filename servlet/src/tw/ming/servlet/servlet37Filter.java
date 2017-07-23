package tw.ming.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;


//urlPatterns= {"/*"}代表全部過濾,
//urlPatterns= {"/iii/*"}在前面多加一層iii作為過濾層:@WebServlet("/iii/servlet01")
//注意:filter不支援非同步操作:servlet3803
@WebFilter(filterName="MingFilter",urlPatterns= {"/iii/*"})
public class servlet37Filter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter init");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		/*
		 * dofilter
		 * service()=chain.doFilter(req, resp);
		 * dofilter
		 * 
		 * */
		System.out.println("do filter : before");
		String user = req.getParameter("user");
		//若user=mingh96b;才讓執行service結果
		if(user!=null && user.equals("ming")) {
			chain.doFilter(req, resp);
		}
		
		System.out.println("do filter :　after");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter destroy");
	}


	

}
