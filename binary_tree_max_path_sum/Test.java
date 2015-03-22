public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		TreeNode root = new TreeNode(-3);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		

		int ret = solver.maxPathSum(root);
		System.out.println(ret);
	}
}