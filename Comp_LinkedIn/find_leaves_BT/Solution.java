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
    public List<List<Integer>> findLeaves(TreeNode root) {
        // recursive version
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		helper(root, ret);
		return ret;
    }

	private int helper(TreeNode root, List<List<Integer>> ret) {
		if (root == null) {
			return 0;
		}
		int height = Math.max(helper(root.left, ret), helper(root.right, ret)) + 1;
		
		if (height > ret.size()) {
			ret.add(new LinkedList<Integer>());
		} 
		ret.get(height-1).add(root.val);
		return height;
	}
}
