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
	}

	
	/*
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
	*/
}