/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode p = root;
		TreeLinkNode firstChild = null; // first child of this level
		TreeLinkNode lastChild = null; // last visted child

		while (p != null) {
			if (p.left != null) {
				if (firstChild == null) {
					firstChild = p.left;
				}
				if (lastChild != null) {
					lastChild.next = p.left;
				}
				lastChild = p.left;
			}
			if (p.right != null) {
				if (firstChild == null) {
					firstChild = p.right;
				}
				if (lastChild != null) {
					lastChild.next = p.right;
				}
				lastChild = p.right;
			}
			if (p.next != null) {
				// if there is more nodes in this level
				p = p.next;
			} else {
				// go to next level
				p = firstChild;
				firstChild = null;
				lastChild = null;
			}
		}
    }
}
