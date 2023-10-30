package tw.org.iii.leetcode;

public class PlusOne66 {
	Solution test = new Solution();

	public static void main(String[] args) {
		PlusOne66 t1 = new PlusOne66();
		int[] ans = t1.test.plusOne(new int[] { 9, 9 });
		for (int a1 : ans) {
			System.out.println(a1);
		}
	}

	private class Solution {
		public int[] plusOne(int[] digits) {
			digits[digits.length - 1] = digits[digits.length - 1] + 1;
			for (int i = digits.length - 1; i >= 0; i--) {
				if (digits[i] == 10) {
					if (i != 0) {
						digits[i] = 0;
						digits[i - 1]++;
					} else {
						digits[i] = 0;
						int[] newDigits = new int[digits.length + 1];
						newDigits[0] = 1;
						for (int j = 0; j < digits.length; j++) {
							newDigits[j + 1] = digits[j];
						}
						return newDigits;
					}
				}
			}
			return digits;
		}
	}
}
