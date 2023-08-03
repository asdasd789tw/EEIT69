package tw.org.iii.yuan;

import java.io.File;

public class Yuan42 {

	public static void main(String[] args) {
		File dir1 = new File("d:/Yuan/dir");
		if(dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		File dir2 = new File("d:/Yuan/test");
		if(dir2.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}//java會把windows路徑符號的\認成跳過字元\n \t...
		//路徑的\可替換成/
		//權限要夠
	}

}
