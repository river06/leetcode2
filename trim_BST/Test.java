import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {1,0,-1,-1,2,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		int L = 1;
		int R = 2;

		TreeNode ret = solver.trimBST(root, L, R);

		TreeNode.printTree(ret);
	}
}
