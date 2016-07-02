/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
		helper(root);
    }
	private TreeNode helper(TreeNode root) {
		// base case
		if(root == null) return null;
		if(root.left==null && root.right==null) return root;

		// process left
		TreeNode left_last = helper(root.left);
		// process right
		TreeNode right_last = helper(root.right);

		if(left_last != null) {
			left_last.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		return right_last == null ? left_last : right_last;
	}
}
