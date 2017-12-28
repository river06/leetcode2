import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] vals = {1, 2, 3, 4, 5};
		ListNode head = ListNode.buildList(vals);
		ListNode.printList(head);

		int k = 3;
		ListNode newHead = solver.reverseKGroup(head, k);

		ListNode.printList(newHead);
	}
}
