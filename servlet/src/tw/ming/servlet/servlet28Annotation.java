package tw.ming.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.jws.soap.InitParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="servlet28Annotation",urlPatterns= {"/servlet240","ming28.jsp","ming28.aspx"},
		initParams={
			@WebInitParam(name="x",value="456"),
			@WebInitParam(name="y",value="456")
		}
)
public class servlet28Annotation extends HttpServlet {
	private ServletConfig servletConfig;
	private ServletContext servletContext;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();//init只會觸發一次
		System.out.println("init");
		servletConfig = getServletConfig();
		//servletConfig.getServletContext()=getServletContext();
		servletContext=getServletContext();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service");
		super.service(req, resp);//觸發doget or dopost
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		Enumeration<String> params = servletConfig.getInitParameterNames();
		while(params.hasMoreElements()) {
			String param=params.nextElement();
			//會輸出initParams裡的東西
			System.out.println(param+":"+servletConfig.getInitParameter(param));
		}
		String realPath = servletContext.getRealPath("");
		System.out.println(realPath);
		
		Set<String> paths = servletContext.getResourcePaths("/");
		//列印出在根目錄下的所有東西
		for(String path:paths) {
			System.out.println(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
