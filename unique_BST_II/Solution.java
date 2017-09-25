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

class Solution {
    public List<TreeNode> generateTrees(int n) {
		if (n == 0) { return new LinkedList<TreeNode>(); }

		return helper(1, n);
    }

	private List<TreeNode> helper(int l, int r) {
		List<TreeNode> ret = new LinkedList<TreeNode>();
        // base case
		if (l > r) {
			ret.add(null);
			return ret;
		}

		for (int i=l; i<=r; i++) {
			List<TreeNode> lTrees = helper(l, i-1);
			List<TreeNode> rTrees = helper(i+1, r);
			for (TreeNode lTree: lTrees) {
				for (TreeNode rTree: rTrees) {
					TreeNode root = new TreeNode(i);
					root.left = lTree;
					root.right = rTree;
					ret.add(root);
				}
			}
		}

		return ret;
	}
}
