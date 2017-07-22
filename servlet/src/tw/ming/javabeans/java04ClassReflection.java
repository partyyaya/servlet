package tw.ming.javabeans;

import java.lang.reflect.Constructor;

public class java04ClassReflection {

	public static void main(String[] args) {
		String[] name= {"ming"};
		Class nameClass = name.getClass();
		System.out.println(nameClass.getName());
		System.out.println(nameClass.isInterface());
		System.out.println(nameClass.isPrimitive());//是否為基本型別
		System.out.println(nameClass.isArray());
		System.out.println(nameClass.getSuperclass().getName());//取得父類別名稱
		System.out.println("--------------");
		
		Class strClass = String.class;
		System.out.println(strClass.getName());
		System.out.println(strClass.isInterface());
		System.out.println(strClass.isPrimitive());//是否為基本型別
		System.out.println(strClass.isArray());
		System.out.println(strClass.getSuperclass().getName());//取得父類別名稱
		System.out.println("--------------");
		
		try {
			Class c1=Class.forName("tw.ming.javabeans.ming051");
			c1.newInstance();//產生物件實體
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("--------------");
		try {
			//得到c2的物件實體
			Class c2=Class.forName("tw.ming.javabeans.ming1");
			System.out.println(c2.getName());
			System.out.println(c2.getPackage().getName());
			Constructor[] cs = c2.getConstructors();
			System.out.println(cs.length);//因只能呼叫到public所以只有public列為計數之內
			for(Constructor cc:cs) {
				Class[] types = cc.getParameterTypes();
				for(Class type:types) {
					System.out.println(type.getName());
				}
				System.out.println("--------------");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

class ming051{
	static {
		System.out.println("Load ming051");
	}
	{
		System.out.println("get ming051");
	}
}
