package tw.ming.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class servlet32ContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println("Add:"+name+":"+value);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println("remove:"+name+":"+value);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println("replace:"+name+":"+value);
	}

}
