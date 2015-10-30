import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		ListNode test = new ListNode(1);
		ListNode node = new ListNode(0);
		ListNode p = test;
		for(int i=2; i<5; i++) {
			
			p.next = new ListNode(i);
			p = p.next;
			if(i==3) {
				node = p;
				System.out.println(node.val);
			}
		}

		ListNode.printList(test);
		
		solver.deleteNode(node);

		ListNode.printList(test);
	}
}
