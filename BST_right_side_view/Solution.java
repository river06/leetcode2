/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
		if(root == null) return ret;
		recur(root, ret, 0, 1);
		return ret;
    }

	private int recur(TreeNode root, List<Integer> ret, int visited_lvl, int cur_lvl) {
		if(root == null) {
			return Math.max(visited_lvl, cur_lvl-1);
		}

		if(cur_lvl > visited_lvl) {
			ret.add(root.val);
			visited_lvl =cur_lvl;
		}

		visited_lvl = recur(root.right, ret, visited_lvl, cur_lvl+1);
		visited_lvl = recur(root.left, ret, visited_lvl, cur_lvl+1);
		return visited_lvl;
	}
}