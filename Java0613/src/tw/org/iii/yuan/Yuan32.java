package tw.org.iii.yuan;

import tw.org.iii.classes.TWid;

public class Yuan32 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg").append("OK").append("XX");//append傳回自己本身
		System.out.println(sb);
		TWid id = TWid.newTWid("A123456789");
		System.out.println(id.getID());
	}

}
