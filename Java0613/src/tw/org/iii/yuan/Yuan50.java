package tw.org.iii.yuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Yuan50 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		File sourse = new File("dir1/A1.jpg");
		try {
			FileOutputStream fout = new FileOutputStream("dir2/5120X3200.jpg");
			FileInputStream fin = new FileInputStream("dir1/5120X3200.jpg");
			int len; byte[] buf = new byte[4*1024];
			while(((len)=fin.read(buf))!=-1) {
				fout.write(buf,0,len);
			}
//			byte[] by=new byte[(int) sourse.length()];
//			fin.read(by);
//			fout.write(by);
			
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("finish:"+(System.currentTimeMillis()-start));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
