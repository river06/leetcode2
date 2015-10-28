/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
		
		TreeNode p = root;
		// right height
		int r_h = 0;
		while(p!=null){
			p=p.right;
			r_h++;
		}
		int l_h = 0;
		p = root;
		while(p!=null){
			p=p.left;
			l_h++;
		}
	
		// short cut
		if(l_h == r_h) return (1<<r_h) -1;

		int ret = 0;
		if(isFullTree(root.left)){
			ret = countNodes(root.right) + (1<<(l_h-1)) -1 +1;
		}else{
			ret = countNodes(root.left) + (1<<(r_h-1))-1 + 1;
		}
		return ret;
    }

	boolean isFullTree(TreeNode root){
		int r_h = 0;
		int l_h = 0;
		TreeNode p = root;
		while(p!=null){
			p=p.right;
			r_h++;
		}
		p = root;
		while(p!=null){
			p=p.left;
			l_h++;
		}
		if(l_h== r_h) {
			return true;
		}else{
			return false;
		}
	}
}
