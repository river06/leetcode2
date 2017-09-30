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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		List<Integer> path = new LinkedList<Integer>();
		helper(root, sum, ret, path);
		return ret;
    }
	private void helper(TreeNode root, int sum,
						List<List<Integer>> ret, List<Integer> path) {
		if (root.left == null && root.right == null && root.val == sum) {
			path.add(root.val);
			ret.add(new LinkedList<Integer>(path));
			path.remove(path.size()-1);
			return;
		}
		path.add(root.val);
		if (root.left != null) {
			helper(root.left, sum-root.val, ret, path);
		}
		if (root.right != null) {
			helper(root.right, sum-root.val, ret, path);
		}
		path.remove(path.size()-1);
	}
}
