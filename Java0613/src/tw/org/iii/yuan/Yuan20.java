package tw.org.iii.yuan;

public class Yuan20 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		
		a = a + b; // a = 13
		b = a - b; // b = 10
		a = a - b; // a = 3
		
		System.out.printf("a = %d , b = %d", a, b);
	}

}
