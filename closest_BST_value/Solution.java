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
    public int closestValue(TreeNode root, double target) {
        double minVal = Double.MAX_VALUE;
		int ret = root.val;
			
		TreeNode p = root;

		while (p != null) {
			double tmp = target - p.val;
			if (Math.abs(tmp) < minVal) {
				minVal = Math.abs(tmp);
				ret = p.val;
			}
			if (tmp == 0) {
				return p.val;
			} else if (tmp > 0) {
				p = p.right;
			} else {
				p = p.left;
			}
		}
		return ret;
    }
}
