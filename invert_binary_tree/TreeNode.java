/**
 * Definition for binary tree
 */

import java.util.*;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

	public static void printTree(TreeNode root) {
		List<List<Integer>> tree = levelOrderTraversal(root);
		for (List<Integer> level: tree) {
			System.out.println(level);
		}
	}
	
	private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        // use two queues to maintain information
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		List<Integer> ret_level = new LinkedList<Integer>();

		if(root == null) return ret;
		
		Queue<TreeNode> this_level = new LinkedList<TreeNode>();
		Queue<TreeNode> next_level = new LinkedList<TreeNode>();

		this_level.add(root);
		while( !this_level.isEmpty() || !next_level.isEmpty() ) {
			if( this_level.isEmpty() ) {
				this_level = next_level;
				next_level = new LinkedList<TreeNode>();
				ret.add( ret_level );
				ret_level = new LinkedList<Integer>();
			} else {
				TreeNode p = this_level.remove();
				if( p.left != null ) next_level.add(p.left);
				if( p.right != null ) next_level.add(p.right);
				ret_level.add( p.val);
			}
		}
		ret.add(ret_level);
		return ret;
    }

	public static TreeNode buildTree(int[] preorder) {
		TreeNode.idx = 0;
		return deserialize(preorder);
	}
	private static int idx = 0;
	private static TreeNode deserialize(int[] preorder) {
		if (TreeNode.idx >= preorder.length ||
			preorder[TreeNode.idx] == -1) {
			TreeNode.idx ++;
			return null;
		}

		TreeNode root = new TreeNode(preorder[TreeNode.idx]);
		TreeNode.idx ++;

		root.left = TreeNode.deserialize(preorder);
		root.right = TreeNode.deserialize(preorder);

		return root;
	}
}
			
 
