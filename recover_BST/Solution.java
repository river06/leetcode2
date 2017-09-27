/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	/**
	 * Morris in-order traversal
	 */
    public void recoverTree(TreeNode root) {
		TreeNode first = null; // first swapped element
		TreeNode second = null; // second swapped element
		TreeNode last = null; // last visited node
		TreeNode cur = null; // current visiting node
		TreeNode tmp = null; // a pointer used to manipulate tree
		
		cur = root;
		while (cur != null) {
			if (cur.left == null) {
				// move to the right
				if (last != null && last.val > cur.val) {
					if (first == null) {
						first = last;
					}
					second = cur;
				}
				last = cur;
				cur = cur.right;
			} else {
				// form the loop. Find the right most child of root's
				// left child, and link it back to root
				tmp = cur.left;
				while (tmp.right != null && tmp.right != cur) {
					tmp = tmp.right;
				}

				if (tmp.right == null) {
					// link back to root, and move to the left child
					// don't have to keep track of last yet. Since we have not started
					// trasversing nodes
					tmp.right = cur;
					cur = cur.left;
				} else {
					// at the back link
					tmp.right = null; // break the link
					if (last.val > cur.val) {
						if (first == null) {
							first = last;
						}
						second = cur;
					}
					last = cur;
					cur = cur.right;
				}
			}
			
		}
		if (first !=null && second != null) {
			int val = first.val;
			first.val = second.val;
			second.val = val;
		}
    }
}
