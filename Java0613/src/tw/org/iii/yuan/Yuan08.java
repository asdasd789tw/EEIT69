package tw.org.iii.yuan;

import java.util.Scanner;

public class Yuan08 {

	public static void main(String[] args) {
		System.out.println("請輸入一個年份");
		Scanner scanner = new Scanner(System.in);		
		int year = scanner.nextInt();
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.printf("%d年份為閏年\n",year);
				}else {
					System.out.printf("%d年份為平年\n",year);
				}
			}else {
				System.out.printf("%d年份為閏年\n",year);
			}
		}else {
			System.out.printf("%d年份為平年\n",year);
		}
	}

}
