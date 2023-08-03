package tw.org.iii.yuan;

public class Yuan10 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		if (a++ <= 10 && b-- >= 3) {
			System.out.printf("OK: a = %d , b = %d", a, b);
		} else {
			System.out.printf("XX: a = %d , b = %d", a, b);
		}
		System.out.println("\n"+(3 & 2));//AND
		System.out.println(3 | 2);//OR
		System.out.println(3 ^ 2);//XOR
	}

}
