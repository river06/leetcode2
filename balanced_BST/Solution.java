/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
		int depth = getLength( root );
		if( depth == -1 ) return false;
		return true;
    }
	
	int getLength( TreeNode root ){
		if( root == null ) return 0;
		
		int left_length = getLength( root.left );
		int right_length = getLength( root.right );
		if( left_length==-1 ||right_length==-1) return -1;
		if( Math.abs( left_length - right_length ) > 1 ) return -1;
		
		return Math.max(left_length, right_length) +1;
	}
}