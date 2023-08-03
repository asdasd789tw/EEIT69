package tw.org.iii.yuan;

public class Yuan13 {

	public static void main(String[] args) {
		int i = 0;
		for (printYuan(); i < 10; printLine()) {
			System.out.println(i++);
		}
		System.out.println("Over:" + i);
	}

	static void printYuan() {
		System.out.println("Yuan");
	}

	static void printLine() {
		System.out.println("------");
	}
}
