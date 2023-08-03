package tw.org.iii.yuan;

public class Yuan31 {

	public static void main(String[] args) {
		String s1 = "Yuan";
		String s4 = s1;
		System.out.println(s1 == s4);
		String s2 = s1.concat("iii");// Return置換後的值 不變更
		System.out.println(s1);
		System.out.println(s2);
		String s3 = s1.replace('a', 'k');// replace Return置換後的值 不變更
		System.out.println(s3);
		s1 = "KKK";// 重新指向該字串記憶體位置
		System.out.println(s1);
		s1 += "OK";// 產生新字串KKKOK位置後重新指向該字串記憶體位置
		System.out.println(s1);
		System.out.println(s1 == s4);
		
		
	}

}
