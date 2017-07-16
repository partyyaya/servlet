package tw.ming.javabeans;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag2 extends SimpleTagSupport {
	//準備一輸出管道
	StringWriter sw = new StringWriter();
	@Override
	public void doTag() throws JspException, IOException {
	
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		//取得標籤內容
		JspFragment body = getJspBody();
		//將管道加入,使其可以填入東西<標籤>body(欲填入字串)<標籤>
		body.invoke(sw);
		
		String mesg = sw.toString();
		out.print("Hello,"+mesg.toUpperCase());
	}
}
