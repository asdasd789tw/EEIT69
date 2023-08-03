package tw.org.iii.yuan;

import java.io.File;

public class Yuan44 {

	public static void main(String[] args) {
		File here = new File(".");//表示本目錄，相對路徑
		System.out.println(here.getAbsolutePath());
		File dir1 = new File("./dir3/dir4/dir5/dir6");
		System.out.println(dir1.getAbsolutePath());
		if(dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			dir1.mkdirs();//建立資料夾 
			//mkdir若無父目錄則無法建立，mkdirs會順便建立父目錄
		}
		
	}

}
