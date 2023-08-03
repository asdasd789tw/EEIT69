package tw.org.iii.yuan;

public class Yuan15 {

	public static void main(String[] args) {
		int dice1, dice2, dice3, dice4, dice5, dice6;
		dice1 = dice2 = dice3 = dice4 = dice5 = dice6 = 0;
		for (int i = 0; i < 10000; i++) {
			int dice = (int) (Math.random() * 6) + 1;
			switch (dice) {
			case 1:
				dice1 = dice1 + 1;
				break;
			case 2:
				dice2 = dice2 + 1;
				break;
			case 3:
				dice3 = dice3 + 1;
				break;
			case 4:
				dice4 = dice4 + 1;
				break;
			case 5:
				dice5 = dice5 + 1;
				break;
			case 6:
				dice6 = dice6 + 1;
			}
		}
		System.out.printf("骰子1出現的次數:%d\n", dice1);
		System.out.printf("骰子2出現的次數:%d\n", dice2);
		System.out.printf("骰子3出現的次數:%d\n", dice3);
		System.out.printf("骰子4出現的次數:%d\n", dice4);
		System.out.printf("骰子5出現的次數:%d\n", dice5);
		System.out.printf("骰子6出現的次數:%d\n", dice6);
		System.out.printf("總次數:%d\n", dice1 + dice2 + dice3 + dice4 + dice5 + dice6);
		//不使用陣列的寫法
	}

}
