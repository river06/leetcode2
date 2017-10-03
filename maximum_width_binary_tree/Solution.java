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
    public int widthOfBinaryTree(TreeNode root) {
		Map<Integer, Integer> L = new HashMap<Integer, Integer>();
		Map<Integer, Integer> R = new HashMap<Integer, Integer>();
        helper(root, 1, 1, L, R);
		int ret = 0;
		for (int d: L.keySet()) {
			if (R.containsKey(d)) {
				ret = Math.max(ret, R.get(d) - L.get(d)+1);
			} else {
				ret = Math.max(ret, 1);
			}
		}
		return ret;
    }

	private void helper(TreeNode root, int idx, int d,
						Map<Integer, Integer> L,
						Map<Integer, Integer> R) {
		if (root == null) { return; }

		if (L.containsKey(d)) {
			int lIdx = L.get(d);
			L.put(d, Math.min(lIdx, idx));
			if (R.containsKey(d)) {
				R.put(d, Math.max(idx, R.get(d)));
			} else {
				R.put(d, Math.max(idx, lIdx));
			}
		} else {
			L.put(d, idx);
		}
		helper(root.left, idx*2, d+1, L, R);
		helper(root.right, idx*2+1, d+1, L, R);
	}
}
