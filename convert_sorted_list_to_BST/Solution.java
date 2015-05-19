/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
import BST_level_order_traversal.*;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // base case
		if(head==null) return null;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode mid = dummy;
		ListNode end = dummy;
		while(end!=null && end.next!=null && end.next.next!=null) {
			mid = mid.next;
			end = end.next.next;
		}
		TreeNode root = new TreeNode(mid.next.val);
		root.right = sortedListToBST( mid.next.next );
		mid.next = null;
		root.left = sortedListToBST( dummy.next );
		return root;
    }
}