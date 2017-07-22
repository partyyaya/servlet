package tw.ming.javabeans;

/*
 * Annotation =>key-value =>metadata
 * 1.Compile Time (若沒@override則不會去檢查父類別)
 * 2.發布時期
 * 3.執行時期(run time)
 * 格式: @Entity
 * ex: @Author(name="ming",date="2017/07/22")
 * 	   @Xxx(value="default")
 * 	   @Xxx("default")
 * 	以下可同時多個相同(會用陣列處理)
 * 	  @Author("default1")
 * 	  @Author("default2")
 *    @Author("default3")
 * */
class test1{
	void m1() {}
	@Deprecated //@Deprecated代表下次改版準備刪除
	void m2() {}
}
class test2 extends test1{
	//@Override若上面寫override則會檢查下面是否符合override父類方法
	void m11() {}

}
public class java01Annotation {

	public static void main(String[] args) {
		test1 obj1 = new test1();
		obj1.m1();
		obj1.m2();

	}

}
