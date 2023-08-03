package tw.org.iii.leetcode;

public class LengthofLastWord58 {
	Solution test = new Solution();

	public static void main(String[] args) {
		LengthofLastWord58 t1 = new LengthofLastWord58();
		System.out.println(t1.test.lengthOfLastWord("Hello World"));
		System.out.println(t1.test.lengthOfLastWord("   fly me   to   the moon  "));
		System.out.println(t1.test.lengthOfLastWord("luffy is still joyboy"));
		System.out.println(t1.test.lengthOfLastWord("joyboy"));
	}

	class Solution {
		public int lengthOfLastWord(String s) {
//			int len = 0;
//			for (int i = s.length() - 1; i >= 0; i--) {
//				if (s.charAt(i) != ' ') {
//					len++;
//				} else if (len != 0 && s.charAt(i) == ' ') {
//					return len;
//				}
//			}
//			return len;
//			方法1 ↑
			
			String[] s1 = s.split(" ");
			return s1[s1.length - 1].length();
		}
	}
}
