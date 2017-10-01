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
    public TreeNode convertBST(TreeNode root) {
		if (root == null) { return root; }
		helper(root, 0);
		return root;
    }

	private int helper(TreeNode root, int curSum) {
		if (root == null) { return 0; }
		int sumR = helper(root.right, curSum);
		int ret = sumR;
		ret += helper(root.left, curSum + root.val + sumR);
		ret += root.val;

		root.val = root.val + sumR + curSum;
		return ret;
	}
}
