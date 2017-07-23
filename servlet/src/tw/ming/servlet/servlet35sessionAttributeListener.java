package tw.ming.servlet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class servlet35sessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		//event.getSession();
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println("add:"+name+":"+value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println("remove:"+name+":"+value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println("replace:"+name+":"+value);
		

		HttpSession session = event.getSession();
		String v2 = (String) session.getAttribute(name);
		System.out.println("replace v2:"+name+":"+v2);
		
	}

}
