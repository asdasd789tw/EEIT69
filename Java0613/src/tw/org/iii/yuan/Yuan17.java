package tw.org.iii.yuan;

public class Yuan17 {

	public static void main(String[] args) {
		int[][] a = new int[3][];
		int sum = 0;
		a[0] = new int[4];
		a[1] = new int[2];
		a[2] = new int[3];
		a[0][0] = 123;
		a[0][1] = 45;
		a[0][2] = 76;
		a[0][3] = 53;

		a[1][0] = 21;
		a[1][1] = 112;

		a[2][0] = 75;
		a[2][1] = 87;
		a[2][2] = 64;

		sum = 0;
		System.out.println("-------");
		for (int[] b : a) {
			for (int c : b) {
				System.out.print(c + " ");
				sum = sum + c;
			}
			System.out.println();
		}
		System.out.println("-------");
		System.out.println("總和為" + sum);
		sum = 0;
		System.out.println("-------");
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
		System.out.println(a[2].length);
		System.out.println("-------");
		System.out.println("陣列長度");
		System.out.println("-------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
				sum = sum + a[i][j];
			}
			System.out.println();
		}
		System.out.println("-------");
		System.out.println("總和為" + sum);
		System.out.println("-------");
	}

}
