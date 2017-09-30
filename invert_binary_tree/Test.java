import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] preorder = {4,2,1,3,7,6,9};
		int[] inorder = {1,2,3,4,6,7,9};
		TreeNode root = TreeNode.buildTree(preorder, inorder);
		TreeNode.printTree(root);

		solver.invertTree(root);

		TreeNode.printTree(root);
	}
}
