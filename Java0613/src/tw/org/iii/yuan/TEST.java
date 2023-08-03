package tw.org.iii.yuan;

import java.util.Arrays;

public class TEST {

	public static void main(String[] args) {
		System.out.println(0%2);
		String s = "()[]{]";
		String temp ="()[]{}" ;
		System.out.println(s.substring(0,1));
		System.out.println(temp.charAt(0));
		if(s.substring(0,1).equals(String.format("%s",temp.charAt(0)))) {
			System.out.println("test");
		}
	}

}
