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
    public String tree2str(TreeNode t) {
		if (t == null) { return ""; }
		if (t.left == null && t.right == null) {
			return ""+t.val;
		}
		String lStr = "";
		String rStr = "";
		if (t.left != null) {
			lStr = tree2str(t.left);
		}
		if (t.right != null) {
			rStr = tree2str(t.right);
		}
		String ret = ""+t.val;
		if (!lStr.isEmpty() || !rStr.isEmpty()) {
			ret += "("+lStr+")";
		}
		if (!rStr.isEmpty()) {
			ret += "("+rStr+")";
		}
		return ret;
    }
}
