import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		int[] preorder = {5, 3, 2, -1, -1, 4, -1, -1, 6, -1, 7, -1, -1};
		TreeNode root = TreeNode.buildTree(preorder);
		TreeNode.printTree(root);

		int key = 3;

		TreeNode ret = solver.deleteNode(root, key);

		TreeNode.printTree(ret);
	}
}
