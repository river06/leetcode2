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
		if (root == null) { return null; }
		
        // pre-order traversal serialization
		StringBuilder sb = new StringBuilder();

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		while (!st.isEmpty()) {
			TreeNode tmp = st.pop();

			if (tmp == null) {
				sb.append("#,");
			} else {
				sb.append(Integer.toString(tmp.val));
				sb.append(",");
				st.push(tmp.right);
				st.push(tmp.left);
			}
		}
		// remove the last comma
		return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
		if (data == null) { return null; }
		
        String[] nodeArr = data.split(",");
		int[] pos = new int[1];
		TreeNode root = reconstruct(nodeArr, pos);
		return root;
    }

	private TreeNode reconstruct(String[] nodeArr, int[] pos) {
		if (pos[0] >= nodeArr.length || nodeArr[pos[0]].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(nodeArr[pos[0]]));
		pos[0] = pos[0] + 1;
		root.left = reconstruct(nodeArr, pos);
		pos[0] = pos[0] + 1;
		root.right = reconstruct(nodeArr, pos);

		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
