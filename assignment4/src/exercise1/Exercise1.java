package exercise1;

public class Exercise1 {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		System.out.println("s1 = " + s1.getNum());
		Singleton s2 = Singleton.getInstance();
		System.out.println("s2 = " + s2.getNum());
		s1.setNum(107);
		System.out.println("s1 after modification: " + s1.getNum());
		System.out.println("s2 after modifying s1: " + s2.getNum());

	}

}
