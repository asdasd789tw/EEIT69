package tw.org.iii.leetcode;

public class FindtheIndexoftheFirstOccurrenceinaString28 {
	private Solution test = new Solution();

	public static void main(String[] args) {
		FindtheIndexoftheFirstOccurrenceinaString28 t1 = new FindtheIndexoftheFirstOccurrenceinaString28();
		System.out.println(t1.test.strStr("leetcode", "leeto"));
		System.out.println(t1.test.strStr("sadbutsad", "sad"));
		System.out.println(t1.test.strStr("aaa", "a"));
		System.out.println(t1.test.strStr("aaa", "aaaa"));
		System.out.println(t1.test.strStr("mississippi", "issipi"));

	}

	class Solution {

		public int strStr(String haystack, String needle) {
			int index = -1;
			int hlen = haystack.length();
			int nlen = needle.length();
			for (int i = 0; i < haystack.length(); i++) {
				if (hlen < nlen) {
					return index;
				}else {
					hlen--;
				}
				if (haystack.charAt(i) == needle.charAt(0)) {
					index = i;
					if (needle.length() == 1) {
						return index;
					}

					for (int j = 1; j < needle.length(); j++) {
						if (haystack.charAt(i + j) != needle.charAt(j)) {
							index = -1;
							break;
						}
						if (j == needle.length() - 1) {
							return index;
						}
					}
				}

			}

			return index;
		}
	}
}
