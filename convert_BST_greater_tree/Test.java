import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {5,2,-1,-1,13,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);

		TreeNode.printTree(root);

		solver.convertBST(root);

		TreeNode.printTree(root);
	}
}
