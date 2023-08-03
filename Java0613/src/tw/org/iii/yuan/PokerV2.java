package tw.org.iii.yuan;

public class PokerV2 {

	public static void main(String[] args) {
		// 1. 洗牌
//		int test = 0;
//		long start = System.currentTimeMillis();
//		System.out.println(start);
		int[] poker = new int[52]; // 0~51
		boolean isRepeat;
		int temp;
		for (int i = 0; i < poker.length; i++) {
			do {
				temp = (int) (Math.random() * 52) + 1;

				// 檢查機制
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (poker[j] == temp) {
						isRepeat = true;
						break;// 重複了
					}
				}
			} while (isRepeat);
			poker[i] = temp;
			System.out.println(poker[i]);
		}
//			test = test + 1;
//		System.out.println(System.currentTimeMillis() - start + "微秒");
//		System.out.println(test);
		// 2. 發牌
		int[][] poker4 = new int[4][13];
		int k = 0;
		for (int i = 0; i < poker4[0].length; i++) {
			for (int j = 0; j < poker4.length; j++) {
				poker4[j][i] = poker[k];
				k++;
			}
		}
		// 3. 攤牌 + 理牌
		for (int b[] : poker4) {
			for (int c : b) {
				System.out.print(c + "\t");
			}
			System.out.println();
		}

	}

}
