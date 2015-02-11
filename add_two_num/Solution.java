/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null ) return l2;
		if(l2 == null ) return l1;
		
		ListNode dummy = new ListNode(0);
		ListNode pr = dummy;
		ListNode p1 = l1;
		ListNode p2 = l2;
		
		int carry = 0;
		
		while( p1 != null || p2 != null ) {
			int digit1 = 0;
			if(p1 != null ) digit1 = p1.val;
			int digit2 = 0;
			if(p2 != null) digit2 = p2.val;
			int digit = (digit1 + digit2 + carry) % 10;
			carry = (digit1 + digit2 + carry) / 10;
			pr.next = new ListNode( digit );
			if(p1 != null) p1 = p1.next;
			if(p2 != null) p2 = p2.next;
			pr = pr.next;
		}
		if( carry == 1) pr.next = new ListNode(1);
		return dummy.next;
    }
}