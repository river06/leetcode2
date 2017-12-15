/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // edge cases
		if (head == null) { return true; }

		// find the middle node
		ListNode p1 = head;
		ListNode p2 = head;
		while (p2 != null && p2.next != null) {
			p2 = p2.next.next;
			p1 = p1.next;
		}
		
		// only one node
		if (p1 == p2) { return true; }
		
		ListNode pSecond = (p2 == null) ? p1 : p1.next;

		// reverse the first part 
		ListNode pFirst = null;
		ListNode pN = head;

		while (pN != p1) {
			ListNode pTmp = pN.next;
			pN.next = pFirst;

			pFirst= pN;
			pN = pTmp;
		}

		// check if linked list is the same from pFirst and pSecond
		p1 = pFirst;
		p2 = pSecond;
		while (p1 != null) {
			if (p1.val != p2.val) {
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return true;
    }
}
