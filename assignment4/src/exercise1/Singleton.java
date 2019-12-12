package exercise1;

public class Singleton {

	private static volatile Singleton instance = null;
	private int num;

	private Singleton() {
		this.num = 32;
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized(Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}

		return instance;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
