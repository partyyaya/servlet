package tw.ming.javabeans;

public class beanUtil {
	public beanUtil() {
		
	}
	
	public beanUtil(String h) {
		System.out.println(h);
	}
	public static String m1() {
		return "hello world";
	}
	
	public static String m1(String u,String v) {
		return u+" hello world "+v;
	}
}
