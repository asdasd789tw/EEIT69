package tw.org.iii.yuan;

public class Yuan100 {

	public static void main(String[] args) {

//		for (int i = 1; i <= 100; i++) {
//			System.out.printf("%d\t", i);
//			if (i % 10 == 0) {
//				System.out.println();
//			}
//		}
		boolean k;
		for (int i = 2; i <= 100; i++) {
			k = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					k = false;
					break;
				}
			}
			if (k) {
				System.out.println(i);
			}
		}	
	}

}
