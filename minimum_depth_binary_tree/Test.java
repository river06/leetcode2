import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		//root.right = new TreeNode(1);
		root.left.left = new TreeNode(2);

		int ret = solver.minDepth(root);

		System.out.println(ret);
	}
}
