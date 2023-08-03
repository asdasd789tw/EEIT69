package tw.org.iii.yuan;

public class Yuan36 {

	public static void main(String[] args) {
		Yuan362 obj1 = new Yuan362();
		Yuan361 obj2 = new Yuan362();
		Yuan363 obj3 = new Yuan362();
		Yuan365 obj4 = new Yuan365();
		
	}

}

interface Yuan361 {
	// interface類別的存取修飾字永遠為public,也隱含抽象類別
	void m1();

	int m2(String a);
}

class Yuan362 implements Yuan361, Yuan363 {
	public void m1() {

	}

	public int m2(String a) {
		return 1;
	}

	public void m3() {

	}

	public int m4(String a) {
		return 1;
	}

}

interface Yuan363 {

	void m3();

	int m4(String a);
}

interface Yuan364 extends Yuan361,Yuan363 {
	// interface類別的存取修飾字永遠為public,也隱含抽象類別
	void m5();

	int m6(String a);
}

class Yuan365 implements Yuan364{
	public void m1() {

	}

	public int m2(String a) {
		return 1;
	}

	public void m3() {

	}

	public int m4(String a) {
		return 1;
	}

	public void m5() {

	}

	public int m6(String a) {
		return 1;
	}
}

//public,protected,沒有,private，四種存取修飾字
//interface與抽象型別的差別:抽象型別內的方法可以被定義供子類別用，
//interface可以繼承多個interface，