package tw.org.iii.classes;

public class Scooter extends Bike {
	private int gear;
	
	public Scooter() {
		// 隱含super();(Bike)
		super("OK");
		System.out.println("Scooter()");
	}
	public void upSpeed() {
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed * (1.9 + gear * 0.3);
		}
	}// Override改寫(複寫)

	public int upGear() {
		if (gear < 4) {
			gear++;
		}
		return gear;
	}

	public int downGear() {
		if (gear > 1) {
			gear--;
		}
		return gear;
	}
}
