/**
 * Definition for singly-linked list.
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

	static void printList(ListNode head) {
		ListNode p = head;
		while(p!=null){
			System.out.print(p.val);
			System.out.print("->");
			p = p.next;
		}
		System.out.println('O');
	}
}
 
