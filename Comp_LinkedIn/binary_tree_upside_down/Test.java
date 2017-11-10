import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
		TreeNode root = TreeNode.buildTree(nodes);
		TreeNode.printTree(root);

		TreeNode ret = solver.upsideDownBinaryTree(root);
		TreeNode.printTree(ret);
	}
}
