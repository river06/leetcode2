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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder traversal
		if (root == null) { return null; }

		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		while( !st.isEmpty() ) {
			TreeNode node = st.pop();

			if (node != null) {
				sb.append(node.val + ",");
				st.push(node.right);
				st.push(node.left);
			}
		}

		return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) { return null; }

		String[] nums = data.split(",");

		TreeNode root = reconstruct(nums, 0, nums.length-1);
		return root;
    }

	private TreeNode reconstruct(String[] nums, int l, int r) {
		if (l > r) { return null; }
		int rootVal = Integer.parseInt(nums[l]);
		TreeNode root = new TreeNode(rootVal);
			
		int m = findRightStart(nums, l+1, r, rootVal);

		root.left = reconstruct(nums, l+1, m-1);
		root.right = reconstruct(nums, m, r);
		return root;
	}

	private int findRightStart(String[] nums, int l, int r, int val) {
		int m = l;
		for(m = l; m<=r; m++) {
			if (Integer.parseInt(nums[m]) > val) {
				break;
			}
		}
		return m;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
