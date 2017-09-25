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
    public boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }

	private boolean helper(TreeNode root, int min, int max, boolean isLUpdate, boolean isRUpdate) {
		if (root == null) { return true; }
		if ( (isRUpdate && root.val >= max ) ||
			 (isLUpdate && root.val <= min) ) {
			return false;
		}

		return helper(root.left, min, root.val, isLUpdate, true) &&
			helper(root.right, root.val, max, true, isRUpdate);
	}
}
