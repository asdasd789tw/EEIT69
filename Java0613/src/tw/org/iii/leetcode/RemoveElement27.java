package tw.org.iii.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElement27 {
	private Solution test = new Solution();

	public static void main(String[] args) {
		RemoveElement27 t1 = new RemoveElement27();
		int[] nums = new int[] { 3, 2, 2, 3 }; // Input array
//		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		int val = 3; // Value to remove
		int[] expectedNums = new int[] { 2, 2 }; // The expected answer with correct length.
		// It is sorted with no values equaling val.

		int k = t1.test.removeElement(nums, val); // Calls your implementation

		assert k == expectedNums.length;
		Arrays.sort(nums, 0, k); // Sort the first k elements of nums
		for (int i = 0; i < expectedNums.length; i++) {
			assert nums[i] == expectedNums[i];
		}

		System.out.println(Arrays.toString(nums) + " " + k);
	}

	private class Solution {
		public int removeElement(int[] nums, int val) {
			int k = 0;
			ArrayList<Integer> newnums = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (!(nums[i] == val)) {
					newnums.add(i);
					k++;
				}
			}
			for (int i = 0; i < newnums.size(); i++) {
				nums[i] = nums[newnums.get(i)];
			}
			return k;
		}
	}
}
