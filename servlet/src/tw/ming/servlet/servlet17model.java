package tw.ming.servlet;

public class servlet17model {
	private int x,y;
	public servlet17model(String x,String y){
		this.x=Integer.parseInt(x);
		this.y=Integer.parseInt(y);
	}
	
	public int add() {return x+y;}
}
