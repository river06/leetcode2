import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(1);*/
		TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(0);

		boolean ret = solver.isSameTree(p, q);

		System.out.println(ret);
	}
}
