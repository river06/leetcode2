import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {2,2,-1,-1,5,5,-1,-1,7,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		int ret = solver.findSecondMinimumValue(root);
		System.out.println(ret);
	}
}
