package tw.org.iii.yuan;

import java.awt.JobAttributes;

import javax.swing.JLabel;

public class Majong {

	public static void main(String[] args) {
//		int[][] majong = new int[4][];
//		majong[0] = new int[9 * 4];// 萬m
//		majong[1] = new int[9 * 4];// 桶p
//		majong[2] = new int[9 * 4];// 條s
//		majong[3] = new int[7 * 4];// 字z
//		for (int i = 0; i < majong.length; i++) {
//			for (int j = 0; j < majong[i].length; j++) {
//				majong[i][j] = j;
//				System.out.print(majong[i][j]+" ");
//			}
//			System.out.println();
//		}// 新麻將

		int[] jpmajong = new int[136];
		for (int i = 0; i < jpmajong.length; i++) {
			jpmajong[i] = i;
		} // 新麻將

		System.out.println("----------");
		int rand = 0;
		int temp = 0;
		for (int i = jpmajong.length - 1; i > 0; i--) {
			rand = (int) (Math.random() * (i + 1));
			temp = jpmajong[rand];
			jpmajong[rand] = jpmajong[i];
			jpmajong[i] = temp;
		} // 洗牌

//		for (int v : jpmajong) {
//			System.out.println(v + " ");
//		} // 檢查洗牌結果

		int[][] mountain = new int[4][34];
		for (int i = 0; i < jpmajong.length; i++) {
			mountain[i % 4][i / 4] = jpmajong[i];
		} // 堆四家牌山

		for (int m[] : mountain) {
			for (int m1 : m) {
				System.out.print(m1 + " ");
			}
			System.out.println();
		} // 檢查牌山

		System.out.println("------------");

		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);
		int dicesum = dice1 + dice2;// 擲骰子

		int position = (4 - (dicesum % 4)) % 4;// 抓牌方位 餘0=mountain[0] 餘1mountain[3] 餘2mountain[2] 餘3mountain[1]
		// (4-餘數)%4

		System.out.println("位置" + position + "\n--------\n" + "骰子總和" + dicesum + "\n--------\n");// 印出開門位置&骰子總和

		int[][] card = new int[4][14]; // 定義四家麻將手牌
		for (int i = 0; i < 53; i++) {
			if (i < 48) {
				card[(i / 4) % 4][i % 4
						+ (i / 16) * 4] = mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
			} else {
				switch (i) {
				case 48:
					card[0][12] = mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
				case 49:
					card[0][13] = mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
				case 50:
					card[1][12] = mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
				case 51:
					card[2][12] = mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
				case 52:
					card[3][12] = mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
				}

			}
		} // 發牌

		for (int c[] : card) {
			for (int c1 : c) {
				System.out.printf("%d\t", c1);
			}
			System.out.println();
		} // 檢查發牌
		JLabel jlabel = new JLabel();

		System.out.println();
//		for (int i = 0; i < jlabel.length; i++) {
//			for (int j = 0; j < card[i].length; j++) {
//				jlabel[i].setText(jlabel[i] + "," + card[i][j]);
//			}
//		}
	}// 發牌
		// 定義麻將花色
		// 理牌
		// 寶牌
}
