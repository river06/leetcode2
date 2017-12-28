/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		
		ListNode nextStart = null;
		ListNode thisStart = head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode preEnd = dummyHead;
		
		while (thisStart != null) {

			// find this end and next start
			int count = 0;
			ListNode thisEnd = preEnd;
			for (int i=0; i<k; i++) {
				thisEnd = thisEnd.next;
				if (thisEnd == null) { break; }
				count++;
			}
			if (count < k) { break; }

			nextStart = thisEnd.next;

			// invert the linked list
			thisEnd.next = null;
			ListNode[] newEdges = invert(thisStart, thisEnd);
			
			// link the list
			preEnd.next = newEdges[0];
			newEdges[1].next = nextStart;
			
			// process for next iteration
			preEnd = newEdges[1];
			thisStart = nextStart;
		}

		return dummyHead.next;
    }

	private ListNode[] invert(ListNode start, ListNode end) {
		ListNode newEnd = start;

		ListNode pre = null;
		ListNode cur = start;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			
			pre = cur;
			cur = next;
		}
		return new ListNode[] {pre, newEnd};	
	}
}
