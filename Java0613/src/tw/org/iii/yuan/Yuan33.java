package tw.org.iii.yuan;

public class Yuan33 {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.m1();
		car1.m2();
		Car car2 = new FCar();//使用FCar使用Car類別
		car2.m1();
		car2.m2();
		FCar car3 = (FCar)car2;//將car2轉換回去FCar類別
		car3.m1();
		car3.m2();
		car3.m3();
		System.out.println(car2 == car3);//是否為相同的物件實體
		MCar car4 = new MCar();
		Car car5 = car4;
		car5.m1();
//		FCar car6 = (FCar)car5;//編譯會過，但執行會發生例外
		System.out.println("-----------");
		doJob(car1);
		doJob(car2);
//		doJob(car3);
		doJob(car4);//使用相同的m1方法，但各型別的m1方法被不同方式複寫，所以輸出結果會不一樣
//		doJob(car5);
		System.out.println("-----------");
		if (car4 instanceof MCar) {
			System.err.println("OK");
		}else {
			System.err.println("XX");
		}//instanceof 判斷血親
	}

	static void doJob(Car car) {
		car.m1();
	}
	
}

class Car {
	void m1() {
		System.out.println("Car:m1()");
	}

	void m2() {
		System.out.println("Car:m2()");
	}
}

class FCar extends Car {
	void m1() {
		System.out.println("FCar:m1()");
	}

	void m3() {
		System.out.println("FCar:m3()");
	}
}

class MCar extends Car {
	void m1() {
		System.out.println("MCar:m1()");
	}

	void m3() {
		System.out.println("MCar:m3()");
	}
}