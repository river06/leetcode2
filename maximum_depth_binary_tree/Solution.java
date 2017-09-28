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
    public int maxDepth(TreeNode root) {
		return helper(root, 0);
    }

	private int helper(TreeNode root, int curDepth) {
		if (root == null) {
			return curDepth;
		}

		return Math.max(helper(root.left, curDepth+1),
						helper(root.right, curDepth+1));
	}
}
