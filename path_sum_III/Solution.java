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
    public int pathSum(TreeNode root, int sum) {
		if (root == null) { return 0; }
		int ret = helper(root, sum);
		if (root.left != null) {
			ret += pathSum(root.left, sum);
		}
		if (root.right != null) {
			ret += pathSum(root.right, sum);
		}
		return ret;
	}
	private int helper(TreeNode root, int target) {
		if (root.left == null && root.right == null) {
			return root.val == target ? 1 : 0;
		}

		int ret = 0;
		if (root.val == target) { ret++; }
		if (root.left != null) {
			ret += helper(root.left, target - root.val);
		}
		if (root.right != null) {
			ret += helper(root.right , target - root.val);
		}

		return ret;
	}
		
}
