package tw.ming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletResponse;

public class servlet41AsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		AsyncContext asyncContext = event.getAsyncContext();
		System.out.println("on complete");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		AsyncContext asyncContext = event.getAsyncContext();
		List<AsyncContext> asyncs = (List<AsyncContext>) asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		asyncs.remove(asyncContext);
		
		HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("沒事");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("on start Async");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		AsyncContext asyncContext = event.getAsyncContext();
		List<AsyncContext> asyncs = (List<AsyncContext>) asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		asyncs.remove(asyncContext);
		
		HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("沒事");
		System.out.println("on Timeout");
	}

}
