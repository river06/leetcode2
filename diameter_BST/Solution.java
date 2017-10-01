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
    public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) { return 0; }
        int[] ret = helper(root);
		return ret[1] -1;
    }

	private int[] helper(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] lLength = helper(root.left);
		int[] rLength = helper(root.right);

		int[] ret = new int[2];

		ret[0] = Math.max(lLength[0], rLength[0]) + 1;
		ret[1] = Math.max(Math.max(lLength[1], rLength[1]), lLength[0] + rLength[0]+1);
		return ret;
	}
}
