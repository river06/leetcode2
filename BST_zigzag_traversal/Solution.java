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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if(root == null) return ret;
		
		Stack<TreeNode> par_stack = new Stack<TreeNode>();
		Stack<TreeNode> child_stack = new Stack<TreeNode>();
		Queue<Integer> lvl_q = new LinkedList<Integer>();
		List<Integer> ret_lvl = new LinkedList<Integer>();
		
		par_stack.push(root);
		lvl_q.offer(0);
		
		while( !par_stack.isEmpty()){
			TreeNode p = par_stack.pop();
			int lvl = lvl_q.poll();
			
			if( lvl == 0 ) {
				if( p.left != null ) {
					child_stack.push(p.left);
					lvl_q.offer(1);
				}
				if( p.right != null ) {
					child_stack.push(p.right);
					lvl_q.offer(1);
				}
			} else {
				if( p.right != null ) {
					child_stack.push(p.right);
					lvl_q.offer(0);
				}
				if( p.left != null ) {
					child_stack.push(p.left);
					lvl_q.offer(0);
				}
			}
			ret_lvl.add(p.val);
			
			if(par_stack.isEmpty()) {
				par_stack = child_stack;
				child_stack = new Stack<TreeNode>();
				ret.add(ret_lvl);
				ret_lvl = new LinkedList<Integer>();
			}
		}
		
		return ret;
    }
}