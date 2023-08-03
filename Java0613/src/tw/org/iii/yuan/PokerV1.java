package tw.org.iii.yuan;

public class PokerV1 {

	public static void main(String[] args) {
		// 1. 洗牌
//		int test = 0;
		long start = System.currentTimeMillis();
		System.out.println(start);
		int[] poker = new int[52]; // 0~51
		for (int i = 0; i < poker.length; i++) {
			int temp = (int) (Math.random() * 52) + 1;

			// 檢查機制
			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (poker[j] == temp) {
					isRepeat = true;
					break;// 重複了
				}
			}
			if (!isRepeat) {
				poker[i] = temp;
				System.out.println(poker[i]);
			} else {
				i--;
			}
//			test = test + 1;
		}
		System.out.println(System.currentTimeMillis() - start + "微秒");
//		System.out.println(test);
		// 2. 發牌
		int[][] poker4 = new int[4][13];
		int k = 0;
		for (int i = 0; i < poker4.length; i++) {
			for (int j = 0; j < poker4[i].length; j++) {
				poker4[i][j] = poker[k];
				k++;
			}
		}
		// 3. 攤牌 + 理牌
		for (int b[] : poker4) {
			for (int c : b) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

	}

}
