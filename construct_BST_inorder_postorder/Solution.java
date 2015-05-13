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
import BST_level_order_traversal.*;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // base case
		if( inorder.length <= 0 ) return null;

		TreeNode root = new TreeNode( postorder[postorder.length-1] );
		int root_idx = indexOfInt(inorder, root.val);
		root.left = buildTree(Arrays.copyOfRange(inorder, 0, root_idx),
							  Arrays.copyOfRange(postorder, 0, root_idx) );
		root.right = buildTree(Arrays.copyOfRange(inorder, root_idx+1, inorder.length),
							   Arrays.copyOfRange(postorder, root_idx, postorder.length-1));
		return root;
    }
	private int indexOfInt(int[] array, int target) {
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
