package tw.org.iii.yuan;

public class Yuan34 {
	public static void main(String[] args) {
		Yuan341 obj1;// = new Yuan341();
		obj1 = new Yuan342();
		Yuan341 obj2 = new Yuan341() {
			void m3() {
				System.out.println("Yuan341:m3()");		
			}
		};//當場實作完成m3方法
		obj2.m3();
	}
}

abstract class Yuan341 {
//	abstract敘述為抽象類別
	void m1() {
		System.out.println("Yuan341:m1()");
	}

	void m2() {
		System.out.println("Yuan341:m2()");
	}

	abstract void m3();// 等待子類別完成該方法
}

class Yuan342 extends Yuan341 {
	void m3() {
		System.out.println("Yuan342:m3()");
	}
}

class Yuan343 extends Yuan341 {
	void m3() {
		System.out.println("Yuan343:m3()");
	}
}