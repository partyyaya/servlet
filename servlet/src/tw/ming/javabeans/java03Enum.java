package tw.ming.javabeans;

public class java03Enum {
	public static final int STOP=1;
	public static final int UP=2;
	public static final int DOWN=3;
	public static final int LEFT=4;
	public static final int RIGHT=5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zone zone1 = Zone.area2;
		Zone zone2 = Zone.area2;
		//System.out.println(zone1==zone2);
		System.out.println(zone1.getCode());
		switch(zone2) {
		 case area1:break;
		 case area2:break;
		 case area3:break;
		 case area4:break;
		}
		int mydir = java03Enum.STOP;
		switch(mydir) {
		case java03Enum.STOP:break;
		 case java03Enum.UP:break;
		 case java03Enum.DOWN:break;
		 case java03Enum.LEFT:break;
		 case java03Enum.RIGHT:break;
		}
	}

}

enum Dir{//若裡面有5個,就代表有5個物件實體
	STOP,UP,DOWN,RIGHT,LEFT
}

enum Zone{
	//若裡面有4個,就代表有4個物件實體 => 呼叫建構式4次
	area1("401"),area2("402"),area3("403"),area4("404");
	private String code;
	private Zone(String code) {
		//System.out.println("Zone");
		this.code=code;
	}
	public String getCode() {
		return code;
	}
}
