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
    public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
        // TreeMap with level order traversal

		Map<Integer, List<Integer>> pos2List = new TreeMap<Integer, List<Integer>>();

		Queue<TreeNode> nodeSt = new LinkedList<TreeNode>();
		Queue<Integer> posSt = new LinkedList<Integer>();
		nodeSt.add(root);
		posSt.add(0);
		
		while (!nodeSt.isEmpty()) {
			TreeNode curNode = nodeSt.poll();
			int curPos = posSt.poll();

			if (!pos2List.containsKey(curPos)) {
				pos2List.put(curPos, new ArrayList<Integer>());
			}
			pos2List.get(curPos).add(curNode.val);

			if (curNode.left != null) {
				nodeSt.offer(curNode.left);
				posSt.offer(curPos - 1);
			}
			
			if (curNode.right != null) {
				nodeSt.offer(curNode.right);
				posSt.offer(curPos + 1);
			}
		}

		// get the list from the sorted map
	
		for (Map.Entry<Integer, List<Integer>> entry: pos2List.entrySet()) {
			ret.add(entry.getValue());
		}

		return ret;
    }
}
