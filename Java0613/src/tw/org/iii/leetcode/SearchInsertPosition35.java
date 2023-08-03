package tw.org.iii.leetcode;

public class SearchInsertPosition35 {
	Solution test = new Solution();

	public static void main(String[] args) {
		SearchInsertPosition35 t1 = new SearchInsertPosition35();
		System.out.println(t1.test.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(t1.test.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(t1.test.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(t1.test.searchInsert(new int[] { 1, 3, 5, 6 }, 0));

	}

	private class Solution {
		public int searchInsert(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] >= target) {
					return i;
				}
			}
			return nums.length;
		}
	}
}
