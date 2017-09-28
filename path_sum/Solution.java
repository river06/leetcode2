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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
		return helper(root, sum);
    }

	private boolean helper(TreeNode root, int sum) {
		if (root == null) {
			return sum == 0;
		}

		if (root.left == null) {
			return helper(root.right, sum-root.val);
		} else if (root.right == null) {
			return helper(root.left, sum-root.val);
		}

		return helper(root.left, sum-root.val) ||
			helper(root.right, sum-root.val);
	}
}
