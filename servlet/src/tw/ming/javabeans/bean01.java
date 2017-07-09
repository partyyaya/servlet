package tw.ming.javabeans;

import java.io.Serializable;

/*
 * JavaBean rules
 * 1.implements Serializable
 * 2.public class
 * 3.field member can not a public
 * 4.getter & setter
 * 5.none argument Constructor (default Constructor)
 * 不一定要預設建構式
 * */
public class bean01 implements Serializable{
	public String id,name;
//	public bean01() {
//		System.out.println("Member()");
//	}
	public bean01(String id ,String name) {
		this.id = id;this.name = name;
		System.out.println(id+":"+name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void m1() {
		System.out.println("m1()");
	}
	@Override
	public String toString() {
		
		return id+":"+name;
	}
	
}
