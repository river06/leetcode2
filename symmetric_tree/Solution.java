/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
		if (root == null) { return true; }
		return helper(root.left, root.right);
    }

	private boolean helper(TreeNode p, TreeNode q) {
		if (p == null || q == null) { return p == q; }
		return p.val == q.val && helper(p.left, q.right) &&
			helper(p.right, q.left);
	}
}
