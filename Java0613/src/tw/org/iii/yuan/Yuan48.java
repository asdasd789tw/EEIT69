package tw.org.iii.yuan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Yuan48 {

	public static void main(String[] args) {
		String mesg = "\n123";
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file3",true);
			//建構式的布林值代表寫出檔案的方式，true是接續在結尾，預設是False，即完全複寫
			fout.write(mesg.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		

	}

}
