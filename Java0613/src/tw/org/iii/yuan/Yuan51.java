package tw.org.iii.yuan;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Yuan51 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/file1");
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}//FileInputStream用InputStreamRead接起來，再用BufferReader接起來
	//也可以直接用FileReader，再用BufferReader接起來

}
