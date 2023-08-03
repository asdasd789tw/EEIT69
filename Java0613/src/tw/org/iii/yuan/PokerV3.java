package tw.org.iii.yuan;

import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		// 買新牌、洗牌
		int num = 52;
		int[] poker = new int[num];
		int rand = 0;
		int temp = 0;
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;
		} // 新牌

		for (int i = num - 1; i > 0; i--) {
			rand = (int) (Math.random() * (i + 1));
			// poker[rand] <=> poker[i]
			temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		} // 洗牌

//		for (int v : poker) {
//			System.out.println(v);
//		} // 印出洗牌結果

//		System.out.println("--------------");

		int[][] players = new int[4][13];
		for (int i = 0; i < poker.length; i++) {
			players[i % 4][i / 4] = poker[i];
		} // 發牌

		for (int i = 0; i < 4; i++) {
			Arrays.sort(players[i]);// 花色排序
			for (int card : players[i]) {
				System.out.print(card + " ");
			}
			System.out.println();
		} // 印牌

		System.out.println("----------");

		String[] colors = { "黑桃", "紅心", "方塊", "梅花" };
		String[] value = { "A ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "J ", "Q ", "K " };
		for (int[] player : players) {
			Arrays.sort(player);// 花色排序
			for (int card : player) {
				System.out.printf("%s%s ", colors[card / 13], value[card % 13]);
			}
			System.out.println();
		} // 定義花色後印牌照花色排序

		System.out.println("----------");
		
		for (int i = 0; i < players.length; i++) {
			for (int j = 0; j < players[i].length; j++) {
				players[i][j] = players[i][j] / 13 + 4 * (players[i][j] % 13);
				System.out.print(players[i][j] + " ");
//				card = card / 13 + 4 * (card % 13);// 理牌公式:i/13 商+4*餘數
			}
			System.out.println();
		}//理牌前重新定義數字方便用於Arrays.sort函數
		
		System.out.println("----------");
		
		for (int[] player : players) {
			Arrays.sort(player);// 排序重新定義後的數字
			for (int card : player) {
				System.out.printf("%s%s ", colors[card % 4], value[card / 4]);
			}
			System.out.println();
		} //印牌並照數字排序
		
//		for (int i = 0; i < 4; i++) {
//			for (int card : players[i]) {
//				System.out.print(card + " ");
//			}
//			System.out.println();
//		} // 印牌1

//		System.out.println("--------------");

//		for (int player[] : players) {
//			for (int card : player) {
//				System.out.print(card + " ");
//			}
//			System.out.println();
//		} // 印牌2

	}
}
