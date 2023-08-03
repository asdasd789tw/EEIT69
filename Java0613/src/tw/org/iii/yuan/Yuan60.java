package tw.org.iii.yuan;

public class Yuan60 {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyRunnable mr1 = new MyRunnable("C");
		Thread t1 = new Thread(mr1);
		mt1.start();
		mt2.start();
		t1.start();
		System.out.println("OK");
	}

}

//class Yuan601{
//	Object m1() {
//		return null ;
//	}
//}
//class Yuan602 extends Yuan601 {
//	String m1(){
//		return null ;
//	}//override時，基本型別要一樣、物件類別要發揚光大、存取權要比父類別大
//}

class MyThread extends Thread {
	private String name;

	MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name + ":" + i);
			try {
				sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

class MyRunnable implements Runnable {
	private String name;

	MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}//本身不是執行緒，需要透過Thread產生執行緒，優點是不需要繼承Thread做父類別，只需要繼承介面
//彈性較大