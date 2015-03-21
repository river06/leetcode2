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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		// use a stack to maintain the pointer
		Stack<TreeNode> tmp_stack = new Stack<TreeNode>();
		TreeNode p = root;

		// push all the left children in the stack
		while(p!=null) {
			tmp_stack.push(p);
			p = p.left;
		}

		while( !tmp_stack.isEmpty() ) {
			p = tmp_stack.pop();
			ret.add(p.val);
			if( p.right != null ) {
				TreeNode p2 = p.right;
				while( p2 != null ) {
					tmp_stack.push(p2);
					p2 = p2.left;
				}
			}
		}
		return ret;
	}
}

/*
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		recur(root,ret);
		return ret;
    }

	private void recur( TreeNode root, List<Integer> ret) {
		if(root == null) return;

		recur(root.left, ret);
		ret.add( root.val);
		recur(root.right, ret);
	}
} */