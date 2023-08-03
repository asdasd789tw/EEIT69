package tw.org.iii.yuan;

import java.util.Scanner;

public class Yuan18 {

	public static void main(String[] args) {
		// 1 + 2 + 3 + ... + n = ?
		System.out.println("n = ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int i = 1;
		int sum = 0;
		while (i <= n) {
			sum = sum + i++;
		}
		System.out.printf("1 + 2 + 3 + ... + %d = %d", n, sum);
	}

}
