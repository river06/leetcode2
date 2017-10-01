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
    public int findBottomLeftValue(TreeNode root) {
		int ret = root.val;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int length = 0;
		while (!queue.isEmpty()) {
			if (length == 0) {
				ret = queue.peek().val;
				length = queue.size();
			}
			TreeNode tmp = queue.poll();
			if (tmp.left != null) { queue.offer(tmp.left); }
			if (tmp.right != null) { queue.offer(tmp.right); }
			length--;
		}

		return ret;
	}
}
