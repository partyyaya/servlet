package tw.ming.javabeans;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag3 extends SimpleTagSupport {
	private String message;
	public void setMessage(String message) {
		this.message=message;
	}
	//準備一輸出管道
	StringWriter sw = new StringWriter();
	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		//有參數message時列印message裡面的的字串,若沒則印出包在tag裡面的東西
		if (message != null) {
	         /* Use message from attribute */
	         JspWriter out = getJspContext().getOut();
	         out.println( message );
	      } else {
	         /* use message from the body */
	         getJspBody().invoke(sw);
	         getJspContext().getOut().println(sw.toString());
	      }
	}
}
