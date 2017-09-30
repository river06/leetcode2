import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] preOrder = {1,2,3};
		int[] inOrder = {2,1,3};
		TreeNode root = TreeNode.buildTree(preOrder, inOrder);

		TreeNode.printTree(root);

		int ret = solver.sumNumbers(root);

		System.out.println(ret);
	}
}
