import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] preorder = {6,2,0,4,3,5,8,7,9};
		int[] inorder = {0,2,3,4,5,6,7,8,9};

		TreeNode root = TreeNode.buildTree(preorder, inorder);

		TreeNode.printTree(root);
		/*TreeNode p = root.left;
		TreeNode q = root.right;*/

		TreeNode p = root.left;
		TreeNode q = root.left.right;
			
		TreeNode ret = solver.lowestCommonAncestor(root, p, q);

		System.out.println( ret.val);
	}
}
