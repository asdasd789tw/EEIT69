package tw.org.iii.yuan;

import tw.org.iii.classes.TWid;

public class Yuan28 {

	public static void main(String[] args) {
		System.out.println(Math.random());//static方法
		System.out.println(TWid.isRightId("A123456789"));//static方法
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Numletters = "1234567890";
		
		System.out.println(letters.indexOf('7'));//查7有無在letters裡面
		String id = "E123456789";

		if (id.matches("[A-Z][1-2][0-9]{8}")) {
			System.out.println("ok");
		} else {
			System.out.println("XX");
		}//正規表示
		
		System.out.println("--------");
		
		if (TWid.isRightId("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
