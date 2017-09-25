public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*TreeNode root = new TreeNode(Integer.MIN_VALUE);
		root.right = new TreeNode(1);*/
		/*TreeNode root = new TreeNode(Integer.MIN_VALUE);
		root.right = new TreeNode(Integer.MAX_VALUE);*/

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
			
		boolean ret = solver.isValidBST(root);
		System.out.println(ret);
	}
}
