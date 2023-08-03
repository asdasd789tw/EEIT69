package tw.org.iii.yuan;

import java.util.Timer;
import java.util.TimerTask;

public class Yuan61 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask1(), 3 * 1000, 1000);
		timer.schedule(new StopTask(timer), 10 * 1000);
		System.out.println("main");
//		StopTask stop = new StopTask();
		// Timer物件需要自己結束
	}

}

class MyTask1 extends TimerTask {
	private int i;

	@Override
	public void run() {
		System.out.println("OK:" + i++);

	}
}

class StopTask extends TimerTask {
	private Timer timer;//互相認識

	public StopTask(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		timer.cancel();//停止所有任務
		timer.purge();//刪除所有任務
		timer = null;//取消指向timer
	}
}
