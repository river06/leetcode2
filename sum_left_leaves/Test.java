import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] preorder = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};
		TreeNode root = TreeNode.buildTree(preorder);
		TreeNode.printTree(root);

		int ret = solver.sumOfLeftLeaves(root);

		System.out.println(ret);
	}
}
