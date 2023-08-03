package tw.org.iii.yuan;

import java.util.LinkedList;

public class Yuan58 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add(0,"Yuan");
		names.add(0,"Brad");
		names.add(0,"Eric");
		names.add(0,"Peter");
		names.add(0,"Amy");
		names.add(0,"Brad");		
		System.out.println(names.size());
		for(String v:names) {
			System.out.println(v);
		}//list可重複、有順序性

	}

}
