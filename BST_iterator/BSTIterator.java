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
public class BSTIterator {
	// not sure if stack is a good way to go
	Stack<TreeNode> node_stack;
	
    public BSTIterator(TreeNode root) {
		node_stack = new Stack<TreeNode>();
        TreeNode p = root;
		while(p != null) {
			node_stack.push(p);
			p = p.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if( node_stack.isEmpty() ) {
			return false;
		} else {
			return true;
		}
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = node_stack.pop();
		if(p.right != null) {
			TreeNode p_p = p.right;
			while( p_p != null ) {
				node_stack.push(p_p);
				p_p = p_p.left;
			}
		}
		return p.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */