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

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
		if( preorder==null || preorder.length == 0) {
			return null;
		}
		int root_val = preorder[0];
		TreeNode root = new TreeNode(root_val);
		int root_idx = findIdx(inorder, root_val);
		root.left = buildTree(Arrays.copyOfRange(preorder, 1, root_idx+1),
							  Arrays.copyOfRange(inorder, 0, root_idx));
		root.right = buildTree(Arrays.copyOfRange(preorder, root_idx+1, preorder.length),
							   Arrays.copyOfRange(inorder, root_idx+1, inorder.length));
		return root;
    }

	private static int findIdx(int[] array, int target) {
		int ret = -1;
		for(int i=0; i<array.length; i++) {
			if(array[i] == target) {
				ret = i;
				break;
			}
		}
		return ret;
	}
 }
 
