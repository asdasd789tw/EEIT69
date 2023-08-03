package tw.org.iii.leetcode;

public class PalindromeNumber09 {
//	檢驗數字有無回文
//	ex:12321 倒過來=12321 有回文
//	122 倒過來=221 沒有回文


	Solution solution = new Solution();

	public static void main(String[] args) {
		PalindromeNumber09 t1 = new PalindromeNumber09();
		System.out.println(t1.solution.isPalindrome(101));
		String t = new String();
	}

	class Solution {
		public boolean isPalindrome(int x) {
			char[] cr = Integer.toString(x).toCharArray();
			boolean test = true;
			for (int i = 0; i < cr.length; i++) {
				if (!(i == (cr.length - 1 - i))) {
					if (cr[i] == cr[cr.length - 1 - i]) {
						test = true;
					} else {
						test = false;
						return test;
					}
				} else {
					return test;
				}
			}
			return test;
		}
	}
}
