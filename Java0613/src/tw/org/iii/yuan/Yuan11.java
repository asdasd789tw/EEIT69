package tw.org.iii.yuan;

import java.util.Scanner;

public class Yuan11 {

	public static void main(String[] args) {
		int a = 1000, c = 10;
		final int b = 10;
		switch (a) {
			case 1:
				System.out.println("A");
				break;
			case b:
				System.out.println("B");
				break;
			case 100:
				System.out.println("C");
			default:
				System.out.println("X");
				break;
			case 1000:
				System.out.println("D");
				break;
		}// case跟if的差別是case是單純比對值的true,false,比對不能是變數,只能是常數
		System.out.println("Game Over");

	}

}
