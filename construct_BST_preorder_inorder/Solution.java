
import BST_level_order_traversal.TreeNode;
import java.util.*;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
		if( preorder==null || preorder.length == 0) {
			return null;
		}
		int root_val = preorder[0];
		TreeNode root = new TreeNode(root_val);
		int root_idx = findIdx(inorder, root_val);
		root.left = buildTree(Arrays.copyOfRange(preorder, 1, root_idx+1),
							  Arrays.copyOfRange(inorder, 0, root_idx));
		root.right = buildTree(Arrays.copyOfRange(preorder, root_idx+1, preorder.length),
							   Arrays.copyOfRange(inorder, root_idx+1, inorder.length));
		return root;
    }

	private int findIdx(int[] array, int target) {
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