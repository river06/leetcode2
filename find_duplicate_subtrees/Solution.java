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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		helper(root, ret, map);
		return ret;
    }

	private String helper(TreeNode root, List<TreeNode> ret, Map<String, Integer> map) {
		if (root == null) { return "#"; }
		String lStr = helper(root.left, ret, map);
		String rStr = helper(root.right, ret, map);

		String treeStr = root.val + "," + lStr + "," + rStr;

		if (map.containsKey(treeStr)) {
			if (map.get(treeStr) == 1) {
				ret.add(root);
				map.put(treeStr, 2);
			}
		} else {
			map.put(treeStr, 1);
		}
		return treeStr;
	}
}
