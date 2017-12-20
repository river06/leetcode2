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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode r = root;
		TreeNode ret = null;
		while (r != null) {
			if (r.val <= p.val) {
				r = r.right;
			} else {
				ret = r;
				r = r.left;
			}
		}

		return ret;
    }
}
