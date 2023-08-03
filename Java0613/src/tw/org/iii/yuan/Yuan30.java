package tw.org.iii.yuan;

import tw.org.iii.classes.TWid;

public class Yuan30 {

	public static void main(String[] args) {
		TWid id1 = new TWid();
		TWid id2 = new TWid(false);
		TWid id3 = new TWid(5);//F
		TWid id4 = new TWid(true,1);//男,B
		System.out.println(id1.getID());
		System.out.println(id2.getID());
		System.out.println(id3.getID());
		System.out.println(id4.getID());

	}

}
