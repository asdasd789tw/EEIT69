package tw.org.iii.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LongestCommonPrefix14 {
	/*
	 * 找出不同字串的最長公共前綴 ex:"flower","flow","flight" 最長公共前綴="fl"
	 * ex:"dog","racecar","car" 最長公共前綴=""
	 */
	private Solution test = new Solution();

	public static void main(String[] args) {
		LongestCommonPrefix14 t1 = new LongestCommonPrefix14();
		String[] strs = { "bab", "batt", "bat" };
		System.out.println(t1.test.longestCommonPrefix(strs));

	}

	private class Solution {
		public String longestCommonPrefix(String[] strs) {
//			String test = "";
//			int len = strs[0].length();
//			char[][] s = new char[strs.length][];
//			LinkedHashSet<Character> temp = new LinkedHashSet<>();
//			ArrayList<Character> lcp = new ArrayList<>();
//			for (int i = 0; i < strs.length; i++) {
//				if (len > strs[i].length()) {
//					len = strs[i].length();
//				}
//				s[i] = strs[i].toCharArray();
//			}
//			for (int i = 0; i < len; i++) {
//				for (int j = 0; j < s.length; j++) {
//					temp.add(s[j][i]);
//				}
//				if (temp.size() == 1) {
//					Iterator<Character> iterator = temp.iterator();
//					lcp.add(iterator.next());
//					temp.clear();
//					test = test + lcp.get(i);
//				} else {
//					return test;
//				}
//			}
//			return test;
			// 爛方法
			if (strs.length == 0)
				return "";

			String prefix = strs[0];
			// 使用strs[0]做處理
			for (int i = 1; i < strs.length; i++) {
				while (strs[i].indexOf(prefix) != 0) {
					// 當indexof沒有索引到0的時候代表prefix字串還沒處理完
					prefix = prefix.substring(0, prefix.length() - 1);
					// 將prefix字串的長度減少1字元後繼續執行While
					if (prefix.isEmpty())
						return "";
					// 如果prefix被處理到變成""代表沒有公共前綴
				}
			}
			// 處理完的prefix等於公共前綴
			return prefix;

		}
	}
}
