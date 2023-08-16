package tw.org.iii.classes;

public class TWid {

	private final static String letters1 = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; // 10,11,...,35
	// static與物件無關 final 宣告後不能再更改
	private String id;// 身分證

	public TWid() {
		this((int) Math.random() * 2 == 0 ? true : false);
	}// 產生隨機身分證

	public TWid(boolean isMale) {
		this(isMale, (int) (Math.random() * 26));
	}// 輸入性別產生隨機身分證

	public TWid(int area) {
		this((int) (Math.random() * 2) == 0 ? true : false, area);
	}// 輸入地區產生隨機身分證

	public TWid(boolean isMale, int area) {
		String c1 = letters1.substring(area, area + 1);
		StringBuffer sb = new StringBuffer(c1);

		sb.append(isMale ? "1" : "2");
		for (int i = 0; i < 7; i++) {
			sb.append((int) (Math.random() * 10));
		}
		for (int i = 0; i < 10; i++) {
			if (isRightId(sb.toString() + i)) {
//				id = sb.toString() + i;
				sb.append(i);
				id = sb.toString();
				break;
			}
		} // 第十碼使用for找合適的檢查碼
			// area => 0 - 25
			// isMale => 0=女 , 1=男
	}// 輸入性別、地區產生隨機身分證

	public String getID() {
		return id;
		
	}

	private TWid(String id) {
		this.id = id;
	}// 建構式

	public static TWid newTWid(String id) {
		if (isRightId(id)) {
			return new TWid(id);
		}else {
			return null;
		}
	};

	public static boolean isRightId(String id) {
		boolean isRight = false;// 首字英文、後9字數字、總長度為10字、第二碼只能為1和2
//		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
//		String Numletters = "1234567890";
//		if (id.length() == 10) {
//			if (letters.indexOf(id.charAt(0)) >= 0) {
//				if (id.charAt(1) == '1' || id.charAt(1) == '2') {
//					for (int i = 2; i < 10; i++) {
//						if (Numletters.indexOf(id.charAt(i)) >= 0) {
//							if (i == 9) {
//								isRight = true;
//							}
//						} else {
//							break;
//						}
//					}
//				}
//			}
//		}用邏輯的寫法

		if (id.matches("[A-Z][1-2][0-9]{8}")) {
			char c1 = id.charAt(0);
			int a12 = letters1.indexOf(c1) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;

			String s1 = id.substring(1, 2);
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));
			int N = a1 * 1 + a2 * 9 + n1 * 8 + n2 * 7 + n3 * 6 + n4 * 5 + n5 * 4 + n6 * 3 + n7 * 2 + n8 * 1 + n9 * 1;
			isRight = N % 10 == 0;

		}
		return isRight;
	}
}
