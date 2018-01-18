/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode slow = dummyHead;
		ListNode fast = dummyHead;
		for (int i=0; i<=n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		ListNode tmp = slow.next.next;
		slow.next.next = null;
		slow.next = tmp;

		return dummyHead.next;
    }
}
