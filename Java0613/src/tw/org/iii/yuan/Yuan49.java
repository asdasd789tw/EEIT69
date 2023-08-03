package tw.org.iii.yuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Yuan49 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/A1.jpg");
			FileInputStream fin = new FileInputStream("dir1/A1.jpg");
			int b;
			while ((b = fin.read()) != -1) {
				fout.write(b);
			}//利用write完成複製貼上的動作
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("finish:"+(System.currentTimeMillis()-start));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
