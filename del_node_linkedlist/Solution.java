/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node==null) return;

		// copy value?

		ListNode dummy = new ListNode(0);
		dummy.next = node;
		ListNode p1 = dummy;
		ListNode p2 = p1.next;
		
		while(p2.next!=null){
			p1.val = p2.val;
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.val = p2.val;
		p1.next = null;
    }
}
