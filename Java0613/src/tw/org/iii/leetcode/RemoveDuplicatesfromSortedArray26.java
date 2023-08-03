package tw.org.iii.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class RemoveDuplicatesfromSortedArray26 {
	private Solution test = new Solution();

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray26 t1 = new RemoveDuplicatesfromSortedArray26();
		int[] nums = { 1, 1, 2 }; // Input array
		int[] expectedNums = { 1, 2 }; // The expected answer with correct length
		int k = t1.test.removeDuplicates(nums); // Calls your implementation
		assert k == expectedNums.length;
		for (int i = 0; i < k; i++) {
			assert nums[i] == expectedNums[i];
		}
		System.out.println(Arrays.toString(nums));
	}

	private class Solution {
		public int removeDuplicates(int[] nums) {
			int k = 0;
			for (int i = 0; i < nums.length; i++) {
				if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
					continue;
				} else {
					nums[k] = nums[i];
					k++;
				}
			}
			return k;
		}
	}

}
