package tw.yuan.apis;

public class Yuan19M {
	private int x, y;

	public Yuan19M(String x, String y) throws Exception {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}

	public int plus() {
		return x + y;
	}
}
