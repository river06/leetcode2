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
    public int sumNumbers(TreeNode root) {
        int ret = 0;
		if (root == null) { return ret; }
		return helper(root, 0);
    }

	private int helper(TreeNode root, int prefix) {
		if (root.left == null && root.right == null) {
			return prefix*10 + root.val;
		}

		int ret = 0;
		if (root.left != null) {
			ret += helper(root.left, prefix*10 + root.val);
		}

		if (root.right != null) {
			ret += helper(root.right, prefix*10 + root.val);
		}
		return ret;
	}
}
