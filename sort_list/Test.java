import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] numbers = {2,1};
		ListNode dummyHead = new ListNode(0);
		ListNode head = dummyHead;
		for( int num: numbers ) {
			head.next = new ListNode( num );
			head = head.next;
		}
		head = dummyHead.next;
		ListNode p = head;
		while ( p!= null ) {
			System.out.print(p.val + "->");
			p = p.next;
		}
		System.out.println("end");
		
		ListNode ret = solver.sortList( head );

		p = ret;

		while ( p != null ) {
			System.out.print(p.val + "->");
			p = p.next;
		}
		System.out.println("end");
	}
}
