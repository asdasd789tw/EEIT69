package tw.org.iii.yuan;

import java.util.Scanner;

public class Yuan03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("X = ");
		int x = scanner.nextInt();
		System.out.print("Y = ");
		int y = scanner.nextInt();
		System.out.print("a = ");
		float a = scanner.nextInt();
		System.out.print("b = ");
		float b = scanner.nextInt();
		int r1 = x + y;
		int r2 = x - y;
		int r3 = x * y;
		int r4 = x / y;
		int r5 = x % y;
		float r6 = a / b;
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(x + " + " + y + " = " + z);
		System.out.printf("%d + %d = %d\n",x,y,r1);//printf使用format代入變數
		System.out.printf("%d - %d = %d\n",x,y,r2);
		System.out.printf("%d * %d = %d\n",x,y,r3);
		System.out.printf("%d / %d = %d ... %d\n",x,y,r4,r5);
		System.out.printf("%f / %f = %f\n",a,b,r6);
		
	}

}
