package tw.org.iii.yuan;

import java.util.HashMap;
import java.util.Set;

public class Yuan59 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Yuan");
		person.put("gender", true);
		person.put("age", 18);
		person.put("weight", 18);
		System.out.println(person.get("name"));
		Set<String> keys = person.keySet();
		for (String v : keys) {
			System.out.println(v + ":" + person.get(v));
		}//利用Set尋訪
		// 類似Python的字典
	}

}
