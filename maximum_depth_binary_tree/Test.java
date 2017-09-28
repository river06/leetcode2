import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(0);

		int depth = solver.maxDepth(root);

		System.out.println(depth);
	}
}
