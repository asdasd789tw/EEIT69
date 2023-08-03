package tw.org.iii.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses20 {
	private Solution test = new Solution();

	public static void main(String[] args) {
		ValidParentheses20 t1 = new ValidParentheses20();
		System.out.println(t1.test.isValid("[[[]"));
//		System.out.println(new String("()[]{}").length());
		Map<Character, Character> parans = Map.of('(', ')', '{', '}', '[', ']');
		//.of方法 可建立不可變物件 Map.of(K1, V1, K2, V2) 不用New就能實作 但也不能對他呼叫有副作用的方法(不可變的特性)
		//Stack 建立向量資料結構(堆盤子)， .peek()方法:return最頂層的元素 .pop()方法:刪除最頂層的元素，.push()方法:新增元素至Stack的最頂層。	
	}

	private class Solution {
		public boolean isValid(String s) {
			boolean test = false;
			if (s.length() % 2 != 0) {
				return false;
			}
			LinkedList<Character> cc = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				if (temp == '(' || temp == '[' || temp == '{') {
					cc.add(temp);
				} else if (temp == ')' || temp == ']' || temp == '}') {
					if (cc.size() > 0) {
						if (cc.getLast() == '(') {
							test = temp == ')';
							cc.removeLast();
						} else if (cc.getLast() == '[') {
							test = temp == ']';
							cc.removeLast();
						} else if (cc.getLast() == '{') {
							test = temp == '}';
							cc.removeLast();
						}
						if (!test) {
							return test;
						}
					} else {
						return false;
					}

				}
			}
			if (!cc.isEmpty()) {
				return false;
			}
			return test;
		}
		
		
	}
}
