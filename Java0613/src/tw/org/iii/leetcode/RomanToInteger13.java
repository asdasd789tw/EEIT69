package tw.org.iii.leetcode;

public class RomanToInteger13 {
//	1~3999的羅馬數字轉換成數字int	
	private Solution test = new Solution();

	public static void main(String[] args) {
		RomanToInteger13 t1 = new RomanToInteger13();
		System.out.println(t1.test.romanToInt("CXCIV"));

	}

	class Solution {
		public int romanToInt(String s) {
//	    	Symbol       Value
//	    	I             1
//	    	V             5
//	    	X             10
//	    	L             50
//	    	C             100
//	    	D             500
//	    	M             1000
			int x = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'M') {
					x = x + 1000;
					if (i != 0 && s.charAt(i - 1) == 'C') {
						x = x - 200;
					}
				} else if (s.charAt(i) == 'D') {
					x = x + 500;
					if (i != 0 && s.charAt(i - 1) == 'C') {
						x = x - 200;
					}
				} else if (s.charAt(i) == 'C') {
					x = x + 100;
					if (i != 0 && s.charAt(i - 1) == 'X') {
						x = x - 20;
					}
				} else if (s.charAt(i) == 'L') {
					x = x + 50;
					if (i != 0 && s.charAt(i - 1) == 'X') {
						x = x - 20;
					}
				} else if (s.charAt(i) == 'X') {
					x = x + 10;
					if (i != 0 && s.charAt(i - 1) == 'I') {
						x = x - 2;
					}
				} else if (s.charAt(i) == 'V') {
					x = x + 5;
					if (i != 0 && s.charAt(i - 1) == 'I') {
						x = x - 2;
					}
				} else if (s.charAt(i) == 'I') {
					x = x + 1;
				}

			}

			return x;
		}
	}
}
