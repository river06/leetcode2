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
    public TreeNode deleteNode(TreeNode root, int key) {
        // recursive find the node to be deleted
		if (root == null) { return null; }
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			// found the node, delete it!
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				// find the minimum node the in right sub tree
				int newKey = findMinRight(root.right);
				// assign the value
				root.val = newKey;
				// delete it from the right sub tree
				root.right = deleteNode(root.right, newKey);
			}
		}
		return root;
    }

	private int findMinRight(TreeNode root) {
		TreeNode p = root;
		while (p.left != null) {
			p = p.left;
		}
		return p.val;
	}
}
