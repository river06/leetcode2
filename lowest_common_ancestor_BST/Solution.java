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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<TreeNode>();
		List<TreeNode> listQ = new ArrayList<TreeNode>();

		DFS(root, p, listP);
		DFS(root, q, listQ);

		for (int i=0; i<Math.min(listP.size(), listQ.size()); i++) {
			if (listP.get(i) != listQ.get(i)) {
				return listP.get(i-1);
			}
		}
		return listP.get( Math.min(listP.size(), listQ.size()) - 1);	
    }

	private boolean DFS(TreeNode root, TreeNode target, List<TreeNode> list) {
		if (root == null) { return false; }
			
		if (root == target) {
			list.add(root);
			return true;
		}
		list.add(root);

		if (DFS(root.left, target, list)) {
			return true;
		} 
		if (DFS(root.right, target, list)) {
			return true;
		}
		
		list.remove(list.size()-1);
		return false;
	}
}
