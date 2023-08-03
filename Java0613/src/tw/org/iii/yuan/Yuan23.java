package tw.org.iii.yuan;

import tw.org.iii.classes.Scooter;

public class Yuan23 {

	public static void main(String[] args) {
		Yuan233 obj1 = new Yuan233();
	}

}

class Yuan231 {
	Yuan231() {
		// 隱含super();(object)
		System.out.println("Yuan231()");
	}
}

class Yuan232 extends Yuan231 {
	Yuan232(){
		// 隱含super();(Yuan231)
		System.out.println("Yuan232()");
	}
}

class Yuan233 extends Yuan232 {
	Yuan233(){
		// 隱含super();(Yuan232)
		System.out.println("Yuan233()");
	}
}
