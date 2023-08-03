package tw.org.iii.leetcode;

public class MergeTwoSortedLists21 {
	private Solution test = new Solution();
//	private ListNode LN1 = new ListNode(4);
//	private ListNode LN2 = new ListNode(2, LN1);
//	private ListNode LN3 = new ListNode(1, LN2);
	private ListNode LNtt;
//	private ListNode LN11 = new ListNode(4);
//	private ListNode LN12 = new ListNode(3, LN11);
//	private ListNode LN13 = new ListNode(1, LN12);

	private ListNode LN21 = new ListNode(2);
	private ListNode LN31 = new ListNode(1);

	public static void main(String[] args) {
		MergeTwoSortedLists21 t1 = new MergeTwoSortedLists21();
		ListNode lnfor = t1.test.mergeTwoLists(t1.LN21, t1.LN31);
		int temp = 0;
		while (temp == 0) {
			try {
				for (int i = 0; i < 6; i++) {
					System.out.println(lnfor.val);
					lnfor = lnfor.next;
				}
			} catch (NullPointerException e) {
				temp = 1;
				System.out.println("END");
			}

		}

	}

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			if (list2 == null) {
				return list1;
			} else if (list1 == null) {
				return list2;
			} else if (list1.val <= list2.val) {
				if (list1.next != null) {
					if (list1.next.val < list2.val) {
						mergeTwoLists(list1.next, list2);
					} else {
						ListNode newlist = list2.next;
						list2.next = list1.next;
						list1.next = list2;
						mergeTwoLists(list1, newlist);
					}
				}else {
					ListNode newlist = list2.next;
					list2.next = list1.next;
					list1.next = list2;
					mergeTwoLists(list1, newlist);
				}

			} else if (list1.val > list2.val) {
				ListNode listtemp = list1;
				list1 = list2;
				list2 = listtemp;
				mergeTwoLists(list1, list2);
			}

			return list1;

//			if (list1 != null && list2 != null) {
//				if (list1.val < list2.val) {
//					list1.next = mergeTwoLists(list1.next, list2);
//					return list1;
//				} else {
//					list2.next = mergeTwoLists(list1, list2.next);
//					return list2;
//				}
//			}
//			if (list1 == null)
//				return list2;
//			return list1;
		}
	}
}
