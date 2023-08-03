package tw.org.iii.yuan;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Yuan41 {

	public static void main(String[] args) {
		Yuan411 obj = new Yuan411();
		try {
			obj.m1();
		} catch (Exception e) {			
		}

	}

}

class Yuan411 {
	void m1() throws Exception {
		m2();
	}

	void m2() throws InterruptedException{
		try {
			m3(1);
		} catch (IOException e) {
			
		}

	}

	void m3(int a) throws IOException,InterruptedException {
		if (a == 1) {
			throw new IOException();
		}else if (a==2) {
			throw new InterruptedException();
		}else if (a==3) {
			throw new FileNotFoundException();
		}
	}

}