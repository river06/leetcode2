/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	private int max_sub = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
		int ret = recur(root);
		ret = Math.max(ret, max_sub);
		return ret;
		
    }

	private int recur(TreeNode root) {
		if(root == null) return 0;

		int right_max = recur(root.right);
		
		int left_max = recur(root.left);

		if(right_max + root.val > max_sub) max_sub = right_max + root.val;
		if(left_max + root.val > max_sub) max_sub = left_max + root.val;
		max_sub = Math.max( max_sub, right_max + left_max + root.val);
		
		int ret = Math.max(right_max+root.val, left_max+root.val);
		ret = Math.max(ret, root.val);
		return ret;
	}

}