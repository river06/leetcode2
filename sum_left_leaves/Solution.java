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
    public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) { return 0; }
		return helper(root, false);
    }

	private int helper(TreeNode root, boolean isLeft) {
		if (root.left == null && root.right == null) {
			return isLeft ? root.val : 0;
		}
		int ret = 0;
		if (root.left != null) {
			ret += helper(root.left, true);
		}

		if (root.right != null) {
			ret += helper(root.right, false);
		}
		return ret;
	}
}
