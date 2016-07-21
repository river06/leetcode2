/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public int rob(TreeNode root) {
		int[] tmp = robTree(root);
		return Math.max(tmp[0], tmp[1]);
	}

	private int[] robTree(TreeNode root) {
		if(root == null) {
			int[] tmp = {0,0};
			return tmp;
		}
		int[] money_l = robTree(root.left);
		int[] money_r = robTree(root.right);

		int[] ret = new int[2];
		ret[0] = Math.max(money_l[0], money_l[1])
			+ Math.max(money_r[0],money_r[1]);
		ret[1] = money_l[0] + money_r[0] + root.val;
		return ret;
	}
}
