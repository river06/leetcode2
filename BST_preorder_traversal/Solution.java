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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
		if(root==null) return ret;
		
		// use stack to manipulate
		Stack<TreeNode> visit_stack = new Stack<TreeNode>();
		visit_stack.push(root);
		
		while( !visit_stack.isEmpty()) {
			TreeNode p = visit_stack.pop();
			if(p.right != null) visit_stack.push(p.right);
			if(p.left != null ) visit_stack.push(p.left);
			ret.add(p.val);
		}
		return ret;
    }
}