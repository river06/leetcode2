import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nodes = {3,5,6,-1,-1,2,7,-1,-1,4,-1,-1,1,0,-1,-1,8,-1,-1};
		TreeNode root = TreeNode.buildTree(nodes);
		TreeNode.printTree(root);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(4);
		TreeNode common = solver.lowestCommonAncestor(root, p, q);
		System.out.println(common.val);
	}
}
