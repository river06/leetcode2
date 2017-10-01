import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {1,2,4,-1,-1,-1,3,-1,-1};
		//int[] pre = {1,2,-1,4,-1,-1,3,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		String str = solver.tree2str(root);

		System.out.println(str);
	}
}
