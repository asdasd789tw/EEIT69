package tw.org.iii.yuan;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Yuan45 {

	public static void main(String[] args) {
		File dir1 = new File("dir1");
		File[] files = dir1.listFiles();
		System.out.println(files.length);
		for(File file :files) {
			Date mtime = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			System.out.printf("%s:%d:%s:%s\n",file.getName(),file.length(),
					file.isDirectory()?"dir":"file",sdf.format(mtime));
		}
	}

}
