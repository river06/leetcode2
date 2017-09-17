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
    public int kthSmallest(TreeNode root, int k) {
        // in order traversal
		Result result = new Result();

		inOrder(root, k, result);

		return result.value;
    }

	private void inOrder(TreeNode root, int k, Result result) {
		if (result.numVisited >= k || root == null) { return; }

		inOrder( root.left, k, result);
		if (result.numVisited < k) {
			result.numVisited++;
			if (result.numVisited == k) {
				result.value = root.val;
			} else {
				inOrder(root.right, k, result);
			}
		}
	}
}

class Result {
	int numVisited = 0;
	int value;
}
