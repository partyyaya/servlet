package tw.ming.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class servlet35RequestListener implements ServletRequestListener {
	
	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		ServletRequest req = event.getServletRequest();
		String remoteIP = req.getRemoteAddr();
		System.out.println("new request from:"+remoteIP);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		
	}

	
}
