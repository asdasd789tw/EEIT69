package tw.org.iii.yuan;

public class Yuan35 {

	public static void main(String[] args) {
		Shape s1 = new RecShape(10, 20);
		Shape s2 = new CircleShape(5);
		sumArea(s1, s2);
		System.out.println(s1.calLength());
		System.out.println(s2.calLength());

	}

	static void sumArea(Shape s1, Shape s2) {
		System.out.println(s1.calArea() + s2.calArea());
	}
}

abstract class Shape {
	abstract double calArea();

	abstract double calLength();
}

class RecShape extends Shape {
	double w, h;

	RecShape(double w, double h) {
		this.w = w;
		this.h = h;
	}

	double calArea() {
		return w * h;
	}

	double calLength() {
		return (w + h) * 2;
	}

}

class CircleShape extends Shape {
	double r;

	CircleShape(double r) {
		this.r = r;
	}

	double calArea() {
		return Math.PI * r * r;
	}

	double calLength() {
		return 2 * Math.PI * r;
	}
}
