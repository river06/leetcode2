import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[] preorder = {10, 5, 3, 3, -1, -1, -2, -1, -1, 2, -1, 1, -1, -1, -3, -1, 11, -1, -1};
		int sum = 8; */
		int[] preorder = {1, -1, 2, -1, 3, -1, 4, -1, 5, -1, -1};
		int sum = 3;
		TreeNode root = TreeNode.buildTree(preorder);
		TreeNode.printTree(root);



		int ret = solver.pathSum(root, sum);

		System.out.println(ret);
	}
}
