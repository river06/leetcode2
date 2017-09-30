import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] preorder = {4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1};
		
		TreeNode root = TreeNode.buildTree(preorder);
		TreeNode.printTree(root);

		solver.invertTree(root);

		TreeNode.printTree(root);
	}
}
