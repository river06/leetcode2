/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
		if(root == null) return ret;
		// visit the tree pre-orderly in reverse
		Stack<TreeNode> visit_stack = new Stack<TreeNode>();
		// the reverse of visited nodes
		Stack<Integer> print_stack = new Stack<Integer>();
		
		visit_stack.push(root);
		while( !visit_stack.isEmpty() ) {
			TreeNode p = visit_stack.pop();
			if(p.left!=null) visit_stack.push(p.left);
			if(p.right!=null) visit_stack.push(p.right);
			print_stack.push(p.val);
		}
		
		while( !print_stack.isEmpty()) {
			ret.add(print_stack.pop());
		}
		return ret;
    }
}


