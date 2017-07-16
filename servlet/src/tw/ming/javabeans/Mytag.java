package tw.ming.javabeans;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		
		super.doTag();
		//JspWriter=out.print
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		out.write("HelloWorld");
	}
}
