package tw.org.iii.yuan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Yuan57 {

	public static void main(String[] args) {
		Set<Integer> lottery = new TreeSet<>();// 放樂透號碼的資料結構
		// TreeSet有排序功能
		while (lottery.size() < 6) {
			lottery.add((int)(Math.random() * 49 + 1));// 1~49
		}
		for(Integer v :lottery) {
			System.out.print(v+",");
		}
	}

}
