package tw.yuan.apis;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class YuanUtils {

	public static String loadView(String view) throws Exception {
		String viewFile = String.format("C:\\Users\\User\\eclipse-workspace\\YuanWeb03\\src\\main\\webapp\\%s.html",
				view);

		File file = new File(viewFile);

		// 第一種讀取方法
//		byte[] buf = new byte[(int) file.length()];
//		FileInputStream fin = new FileInputStream(file);
//		fin.read(buf);
//		fin.close();
//
//		return new String(buf);
		// 第一種讀取方法

		// 第二種讀取方法
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
		// 第二種讀取方法
	}

	public static String sayYa() {
		return "YA";
	}

	public static String sayYa(String name) {
		return String.format("YA,%s", name);
	}

	public static String calc(String x, String y,String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			String result = "" ;
			switch (op) {
			case "1":
				result = (intX + intY)+""; 
				break;
			case "2":
				result = (intX - intY)+"";
				break;
			case "3":
				result = (intX * intY)+"";
				break;
			case "4":
				result = (intX / intY)+"......"+(intX % intY);
				break;				
			}
			return result;
		} catch (Exception e) {
			return "";
		}

		
	}
	
	public static Member createMember() {
		return new Member(123,"iii","III","1999-09-09");
	}
}
