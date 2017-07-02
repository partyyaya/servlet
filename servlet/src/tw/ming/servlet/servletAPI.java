package tw.ming.servlet;

public class servletAPI {

	public static String getHeaderFileName(String header) {
		//form-data; name="upload"; filename="slide-books.png"
		//filename=":+10 後 c:
		int start=header.indexOf("filename");
		String temp = header.substring(start+10);
		String filename=temp.substring(0,temp.lastIndexOf("\""));
		int s1 = filename.lastIndexOf("\\");
		
		String sfile = null;
		if (s1>=0) {
			sfile = filename.substring(
				filename.lastIndexOf("\\")+1);
		}else {
			sfile = filename;
		}
		return sfile;
	}
}
