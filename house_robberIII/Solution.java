/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;

		int money_left = rob(root.left);
		int money_left_child = root.left == null ?
			0 : rob(root.left.left) + rob(root.left.right);
		int money_right = rob(root.right);
		int money_right_child = root.right == null ?
			0 : rob(root.right.left) + rob(root.right.right);
		return Math.max(money_left+money_right,
						root.val + money_left_child + money_right_child);
    }
}
