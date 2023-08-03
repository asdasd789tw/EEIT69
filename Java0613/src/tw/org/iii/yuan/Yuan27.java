package tw.org.iii.yuan;

import tw.org.iii.classes.Scooter;

public class Yuan27 {

	public static void main(String[] args) {
		Object o1 = new Object();
		String s1 = new String("Yuan");
		String s2 = new String("Yuan");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(o1);

		Scooter s3 = new Scooter();
		System.out.println(s3);
		System.out.println("----");
		System.out.println(s1.equals(s2));
		
		
	}

}
