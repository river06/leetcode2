import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(1);
		int sum = 1;
		boolean ret = solver.hasPathSum(root, sum);

		System.out.println(ret);
	}
}
