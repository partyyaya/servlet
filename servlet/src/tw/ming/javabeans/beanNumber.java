package tw.ming.javabeans;

public class beanNumber {
	private String guessNumber,randNumber;
	private int a,b;

	public String getA() {
		return a+"";
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getB() {
		return b+"";
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getGuessNumber() {
		return guessNumber;
	}

	public void setGuessNumber(String guessNumber) {
		this.guessNumber = guessNumber;
	}

	public String getRandNumber() {
		return randNumber;
	}

	public void setRandNumber(String randNumber) {
		this.randNumber = randNumber;
	}

	
}
