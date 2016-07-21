import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		// TreeNode root = new TreeNode(3);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.right = new TreeNode(3);
		// root.right.right = new TreeNode(1);

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);

		System.out.println( solver.rob(root) );
	}
}
