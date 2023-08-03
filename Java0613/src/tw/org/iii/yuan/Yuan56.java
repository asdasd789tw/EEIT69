package tw.org.iii.yuan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Yuan56 {

	public static void main(String[] args) {

		Set set = new HashSet();
		set.add(123);
		set.add(12.3);
		set.add(true);
		set.add("Yuan");
		set.add("Yuan");
		set.add(123);
		System.out.println(set.size());
		System.out.println(set);// set已經內建override toString
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}//Set不可重複、無順序性

	}

}
