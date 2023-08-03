package tw.org.iii.yuan;

public class Yuan12 {

	public static void main(String[] args) {
//		System.out.println("請輸入月份:");
//		Scanner scanner = new Scanner(System.in);
//		int month = scanner.nextInt();		
		int month = (int) (Math.random() * 12) + 1;
		int days = 0;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			days = 31;
			System.out.printf("%d月有%d天", month, days);
			break;
		case 4, 6, 9, 11:
			days = 30;
			System.out.printf("%d月有%d天", month, days);
			break;
		case 2:
			days = 28;
			System.out.printf("%d月有%d天", month, days);
			break;
		default:
			System.out.println("沒有該月份!");
		}

	}

}
