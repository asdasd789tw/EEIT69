package tw.org.iii.yuan;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.org.iii.classes.Student;

public class Yuan54 {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/student.txt"));
			Object obj = oin.readObject();
			if (obj instanceof Student) {
				System.out.println("ok");
			}
			
			Student s1 = (Student)obj;
			System.out.println(s1.getName());
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			
			oin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
