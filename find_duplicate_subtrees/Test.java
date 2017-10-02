import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {1,2,4,-1,-1,-1,3,2,4,-1,-1,-1,4,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		List<TreeNode> ret = solver.findDuplicateSubtrees(root);

		for (TreeNode node: ret) {
			TreeNode.printTree(node);
		}
	}
}
