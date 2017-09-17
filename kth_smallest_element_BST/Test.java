import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		// case 1
		/*TreeNode root = new TreeNode(1);
		int k = 1;*/

		// case 2
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		int length = 2;*/

		// Case 3
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(3);
		int length = 4;
		
		for (int k=1; k<=length; k++) {

			int ret = solver.kthSmallest(root, k);

			System.out.println(k + ": " +ret);
		}
	}
}
