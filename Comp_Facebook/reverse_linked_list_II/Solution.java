/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) { return head; }

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		
        // find the first node
		ListNode firstEnd = dummyHead;
		for (int i=0; i<m-1; i++) {
			firstEnd = firstEnd.next;
		}

		ListNode secondEnd = firstEnd.next;

		ListNode pre = null;
		ListNode cur = secondEnd;
		ListNode next = null; 
		for (int i=0; i<=n-m; i++) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		firstEnd.next = pre;
		secondEnd.next = next;

		return dummyHead.next;
    }
}
