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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length-1);
		return root;
    }

	private TreeNode helper(int[] nums, int l, int r) {
		if (l > r) {
			return null;
		}
		int idx = findMaxIdx(nums, l, r);
		TreeNode root = new TreeNode(nums[idx]);
		root.left = helper(nums, l, idx-1);
		root.right = helper(nums, idx+1, r);
		return root;
	}

	private int findMaxIdx(int[] nums, int l, int r) {
		int idx = l;
		int max = nums[idx];

		for (int i=l+1; i<=r; i++) {
			if (nums[i] > max) {
				idx = i;
				max = nums[i];
			}
		}
		return idx;
	}
}
