/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;
import BST_level_order_traversal.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // base case
		if(nums == null || nums.length ==0) return null;

		int mid_idx = nums.length/2;
		TreeNode root = new TreeNode(nums[mid_idx]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid_idx));
		root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid_idx+1, nums.length));
		return root;
    }
}