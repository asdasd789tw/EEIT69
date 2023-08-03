package tw.org.iii.yuan;

public class Yuan16 {

	public static void main(String[] args) {
		int point;
		int[] dice = new int[7];
		int sum = 0;

		for (int i = 0; i < 100; i++) {
			point = (int) (Math.random() * 6) + 1;
			if (point >= 1 && point <= 6) {
				dice[point]++;
			} else {
				dice[0]++;
			}
		}

		if (dice[0] == 0) {
			for (int i = 1; i <= 6; i++) {
				System.out.printf("骰子%d出現的次數:%d\n", i, dice[i]);
			}
		} else {
			System.out.println("XX");
		}
		for (int s : dice) {
			sum = sum + s;
		}
		System.out.printf("總次數:%d", sum);
		// 使用陣列的寫法

//		int point;
//		int[] dice = new int[7];
//		int sum = 0;
//
//		for (int i = 0; i < 100; i++) {
//			point = (int) (Math.random() * 9) + 1;
//			if (point >= 1 && point <= 9) {
//				dice[point >= 7 ? point - 3 : point]++;
//			} else {
//				dice[0]++;
//			}
//		}
//
//		if (dice[0] == 0) {
//			for (int i = 1; i <= 6; i++) {
//				System.out.printf("骰子%d出現的次數:%d\n", i, dice[i]);
//			}
//		} else {
//			System.out.println("XX");
//		}
//		for (int s : dice) {
//			sum = sum + s;
//		}
//		System.out.printf("總次數:%d", sum);
		// 詐賭寫法
	}
}
