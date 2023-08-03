package tw.org.iii.yuan;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.org.iii.classes.Student;

public class Yuan53 {

	public static void main(String[] args) {
		Student s1 = new Student(99, 37, 60,"Yuan");
		System.out.println(s1.getName());
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		
		try (FileOutputStream fout = new FileOutputStream("dir1/student.txt");
				ObjectOutputStream oout = new ObjectOutputStream(fout);) {
			oout.writeObject(s1);
			oout.flush();
		} catch (Exception e) {
			System.out.println(e);
		}//ObjectOutputStream 將物件進行可序列化，基本型別本身也是物件，可序列化
	}

}
