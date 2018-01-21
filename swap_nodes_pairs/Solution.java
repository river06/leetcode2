/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) { return head; }
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode lastTail = dummyHead;

		while (head != null && lastTail != null) {
			ListNode[] newHeadTailNext = reverse(head);
			lastTail.next = newHeadTailNext[0];
			lastTail = newHeadTailNext[1];
			head = newHeadTailNext[2];
		}

		return dummyHead.next;
    }

	ListNode[] reverse(ListNode head) {
		ListNode tail = head.next;
		ListNode nextHead = tail == null ? null : tail.next;
		if (tail != null) {
			tail.next = head;
			head.next = null;
			return new ListNode[] { tail, head, nextHead };
		} else {
			return new ListNode[] { head, null, null };
		}
	}
}
