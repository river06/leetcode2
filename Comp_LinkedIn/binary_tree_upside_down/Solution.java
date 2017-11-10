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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) { return null; }
		TreeNode parent = null;
		TreeNode current = root;
		TreeNode right = null;

		while (current != null) {
			TreeNode tmpR = current.right;
			TreeNode tmpL = current.left;
			current.left = right;
			current.right = parent;
			parent = current;
			right = tmpR;
			current = tmpL;
		}

		return parent;
    }
}
