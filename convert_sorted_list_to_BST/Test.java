
import java.util.*;
import BST_level_order_traversal.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0; i<array.length; i++) {
			p.next = new ListNode(array[i]);
			p = p.next;
		}
		
		TreeNode root = solver.sortedListToBST(head);

		BST_level_order_traversal.Solution solver2 =
			new BST_level_order_traversal.Solution();
		List<List<Integer>> ret2 = solver2.levelOrder(root);
		for(List<Integer> level : ret2) {
			System.out.println( level.toString() );
		}
	}
}
