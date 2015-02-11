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
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();

		que.add( root );

		while( !que.isEmpty() ) {
			TreeNode this_root = que.remove();
			System.out.print( this_root.val);
			System.out.print( "-" );
			if( this_root.left != null ) que.add(this_root.left );
			if( this_root.right != null ) que.add(this_root.right);
		}
		System.out.println(" ");
	}
	
 }
 