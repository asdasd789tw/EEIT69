package tw.org.iii.classes;

import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPMajong extends JPanel {
	private int[] JPMajong;
	private int rand, temp, dice1, dice2, dicesum, position;
	private int[][] Mountain, card;
	private JLabel[] jlabel;
	private LinkedList<LinkedList<String>> mountainList, cardList;// 存放刪除用##

	public JPMajong() {
		JPMajong = new int[136];
		jlabel = new JLabel[4];
		mountainList = new LinkedList<>();
		cardList = new LinkedList<>();
		setBackground(Color.GREEN);
		for (int i = 0; i < JPMajong.length; i++) {
			JPMajong[i] = i;
		} // 新麻將
		Shuffle();
		PileUp();
		dice();
		deal();
	}

	
	public void Shuffle() {
		for (int i = JPMajong.length - 1; i > 0; i--) {
			rand = (int) (Math.random() * (i + 1));
			temp = JPMajong[rand];
			JPMajong[rand] = JPMajong[i];
			JPMajong[i] = temp;
		}
	}// 洗牌

	public void PileUp() {
		Mountain = new int[4][34];
		for (int i = 0; i < JPMajong.length; i++) {
			Mountain[i % 4][i / 4] = JPMajong[i];
		} // 堆四家牌山
		for (int i = 0; i < Mountain.length; i++) {
			LinkedList<String> mtlist = new LinkedList<>();
			for (int j = 0; j < Mountain[i].length; j++) {
				mtlist.add(Integer.toString(Mountain[i][j]));
			}
			mountainList.add(mtlist);
		} // 放進LinkedList內
	}

	public void dice() {
		dice1 = (int) (Math.random() * 6 + 1);
		dice2 = (int) (Math.random() * 6 + 1);
		dicesum = dice1 + dice2;
		position = (4 - (dicesum % 4)) % 4;// 抓牌方位 餘0=mountain[0] 餘1mountain[3] 餘2mountain[2] 餘3mountain[1]
		// (4-餘數)%4
	}// 擲骰子、取位置

	public void deal() {
		card = new int[4][14];// 定義四家麻將手牌
		for (int i = 0; i < card.length; i++) {
			card[i][13] = 136;
		}
		for (int i = 0; i < 53; i++) {
			if (i < 48) {
				card[(i / 4) % 4][i % 4
						+ (i / 16) * 4] = Mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
				mountainList.get((position + ((dicesum * 2 + i) / 34)) % 4)
						.remove(((dicesum * 2 + i) <= 34 ? dicesum * 2 : 0));// 發牌到玩家手上後移除牌山List內的牌
			} else {
				switch (i) {
				case 48:
					card[0][12] = Mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
					mountainList.get((position + ((dicesum * 2 + i) / 34)) % 4)
					.remove(((dicesum * 2 + i) <= 34 ? dicesum * 2 : 0));// 發牌到玩家手上後移除牌山List內的牌
					break;
				case 49:
					card[0][13] = Mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
					mountainList.get((position + ((dicesum * 2 + i) / 34)) % 4)
					.remove(((dicesum * 2 + i) <= 34 ? dicesum * 2 : 0));// 發牌到玩家手上後移除牌山List內的牌
					break;
				case 50:
					card[1][12] = Mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
					mountainList.get((position + ((dicesum * 2 + i) / 34)) % 4)
					.remove(((dicesum * 2 + i) <= 34 ? dicesum * 2 : 0));// 發牌到玩家手上後移除牌山List內的牌
					break;
				case 51:
					card[2][12] = Mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
					mountainList.get((position + ((dicesum * 2 + i) / 34)) % 4)
					.remove(((dicesum * 2 + i) <= 34 ? dicesum * 2 : 0));// 發牌到玩家手上後移除牌山List內的牌
					break;
				case 52:
					card[3][12] = Mountain[(position + ((dicesum * 2 + i) / 34)) % 4][(dicesum * 2 + i) % 34];
					mountainList.get((position + ((dicesum * 2 + i) / 34)) % 4)
					.remove(((dicesum * 2 + i) <= 34 ? dicesum * 2 : 0));// 發牌到玩家手上後移除牌山List內的牌
					break;
				}

			}
		}
		for (int i = 0; i < jlabel.length; i++) {
			jlabel[i] = new JLabel();
			for (int j = 0; j < card[i].length; j++) {
				jlabel[i].setText(jlabel[i].getText() + card[i][j] + ",");
			}
		}

//		for (int i = 0; i < card.length; i++) {
//			cardList.add(card[i]);
//		}
//		System.out.println(cardList.getFirst());
	}// 發牌

	public void Mountainname() {
		String[] number = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] type = { "萬", "筒", "條", };
		String[] type1 = { "東", "南", "西", "北", "白", "發", "中" };
		for (int[] c1 : Mountain) {
//			LinkedList<String> mtlist = new LinkedList<>();
			for (int c2 : c1) {
				if (c2 < 108) {
					if (c2 == 19 || c2 == 55 || c2 == 91) {
//						mtlist.add("紅" + number[(c2 / 4) - (9 * (c2 / 36))] + type[c2 / 36]);
						System.out.printf("紅%s%s ", number[(c2 / 4) - (9 * (c2 / 36))], type[c2 / 36]);
					} else {
//						mtlist.add(number[(c2 / 4) - (9 * (c2 / 36))] + type[c2 / 36]);
						System.out.printf("%s%s ", number[(c2 / 4) - (9 * (c2 / 36))], type[c2 / 36]);
					}
				} else if (c2 == 136) {
					System.out.print("");
				} else {
//					mtlist.add(type1[(c2 - 108) / 4]);
					System.out.printf("%s ", type1[(c2 - 108) / 4]);
				}

			}
//			mountainList.add(mtlist);
			System.out.println();
		} // 定義牌山麻將牌名稱後印牌 不能排序
		System.out.println("---------------------");
		for (int i = 0; i < mountainList.size(); i++) {
			for (int j = 0; j < mountainList.get(i).size(); j++) {
				System.out.print(mountainList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public void cardname() {
		String[] number = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] type = { "萬", "筒", "條", };
		String[] type1 = { "東", "南", "西", "北", "白", "發", "中" };
		for (int[] c1 : card) {
			Arrays.sort(c1);// 花色排序
			for (int c2 : c1) {
				if (c2 < 108) {
					if (c2 == 19 || c2 == 55 || c2 == 91) {
						System.out.printf("紅%s%s ", number[(c2 / 4) - (9 * (c2 / 36))], type[c2 / 36]);
					} else {
						System.out.printf("%s%s ", number[(c2 / 4) - (9 * (c2 / 36))], type[c2 / 36]);
					}
				} else if (c2 == 136) {
					System.out.print("");
				} else {
					System.out.printf("%s ", type1[(c2 - 108) / 4]);
				}

			}
			System.out.println();
		} // 定義手牌麻將牌名稱後印牌且照花色排序
	}

	public JLabel getcard(int position) {
		return jlabel[position];
	}// 取得牌

	// 牌山的資料結構要在發牌後remove，之後打牌也要隨時remove done
	// 圖片的lintener要用jlabel設為image實現
	
}
