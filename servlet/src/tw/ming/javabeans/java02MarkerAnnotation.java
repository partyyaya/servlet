package tw.ming.javabeans;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class java02MarkerAnnotation {

	public static void main(String[] args) {
		Ming031 obj1 = new Ming031();
		obj1.m1();
		Ming032 obj2 = new Ming032();
		obj2.m1();
		Ming033 obj3 = new Ming033();
		obj3.m1();
		Ming034 obj4 = new Ming034();
		obj4.m1();
		Ming035 obj5 = new Ming035();
		obj5.m1();
		Ming036 obj6 = new Ming036();
		obj6.m1();
	}
}
/*
 * Marker Annotation => 自己本身提供資訊
 * */
//1.
@interface Debug{}

class Ming031{
	@Debug
	void m1() {}
}

//2.
@interface Debug2{
	String value();
}
class Ming032{
	@Debug2(value="2")
	void m1() {}
}
class Ming033{
	@Debug2("2")
	void m1() {}
}

//3.
@interface Debug3{
	String[] value();
}
class Ming034{
	@Debug3(value= {"2","3","4","5"})
	void m1() {}
}

//4.
//若要使用此些數值族必須宣告此行(處理runtime)
@Retention(RetentionPolicy.RUNTIME)
@interface Debug4{
	String[] value() default "debug4";
}
class Ming035{
	@Debug4(value= {"a","b","c"})//可以只寫@Debug4 則會印出default預設值
	public void m1() {
		try {
			Debug4 debug4 = getClass().getMethod("m1", null).getAnnotation(Debug4.class);
			String[] values = debug4.value();
			for(String value :values) {
				System.out.println(value);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

//5.
//若要使用此些數值族必須宣告此行(處理runtime)
@Retention(RetentionPolicy.RUNTIME)
@interface Debug5{
	//enum:類舉
	public  enum Dir{
		STOP,UP,DOWN,RIGHT,LEFT
	}
	Dir dir() default Dir.STOP;
	String[] names()default "guest";
	boolean isWinner() default false;	
}
class Ming036{
	@Debug5(
			dir = Debug5.Dir.LEFT,
			names= {"ming01","ming02"}
	)
	public void m1() {
		try {
			Debug5 debug5 = getClass().getMethod("m1", null).getAnnotation(Debug5.class);
			String[] names = debug5.names();
			for(String name :names) {
				System.out.println(name);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}

