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

	static ListNode buildList(int[] vals) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		for (int i=0; i<vals.length; i++) {
			p.next = new ListNode(vals[i]);
			p = p.next;
		}
		return dummyHead.next;
	}
	
	static void printList(ListNode head) {
		ListNode p = head;
		while(p!=null){
			System.out.print(p.val);
			System.out.print("->");
			p = p.next;
		}
		System.out.println('@');
	}
}
 
