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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
				ret.add( 0, ret_level );
				ret_level = new LinkedList<Integer>();
			} else {
				TreeNode p = this_level.remove();
				if( p.left != null ) next_level.add(p.left);
				if( p.right != null ) next_level.add(p.right);
				ret_level.add( p.val);
			}
		}
		ret.add(0,ret_level);
		return ret;
    }
}