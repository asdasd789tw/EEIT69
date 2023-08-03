package tw.org.iii.yuan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Yuan55 {

	public static void main(String[] args) {
		Yuan553 obj = new Yuan553();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("-------");
			ObjectInputStream ooin = new ObjectInputStream(new FileInputStream("dir1/test"));
			Object obj1 = ooin.readObject();
			ooin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}


}

class Yuan551 implements Serializable{
	Yuan551(){
		System.out.println("Yuan551()");
	}
}
class Yuan552 extends Yuan551 {
	Yuan552(){
		System.out.println("Yuan552()");
	}
}
class Yuan553 extends Yuan552 {
	Yuan553(){
		System.out.println("Yuan553()");
	}
}