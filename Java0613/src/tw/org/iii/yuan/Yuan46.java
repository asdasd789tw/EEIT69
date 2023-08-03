package tw.org.iii.yuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Yuan46 {

	public static void main(String[] args) {
		File sourse = new File("dir1/file1");
		try {
			FileInputStream fin = new FileInputStream(sourse);
			int len;
			byte[] buf = new byte[(int) sourse.length()];
//			while ((len = fin.read(buf) )!= -1) {
//				System.out.print((new String(buf,0,len)));
//			}
			fin.read(buf);
			System.out.println(new String(buf));
			System.out.println();
			fin.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

}
