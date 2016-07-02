import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		TreeNode.printTree(root);
		solver.flatten(root);
		TreeNode.printTree(root);
	}
}
