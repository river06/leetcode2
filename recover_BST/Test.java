public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		
		/*TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);*/

		/*TreeNode root = new TreeNode(2);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(1);*/

		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		
		solver.recoverTree(root);

		System.out.println("solved");
		inOrderPrint(root);
	}

	public static void inOrderPrint(TreeNode root) {
		if(root == null) return;
		inOrderPrint(root.left);
		System.out.println(root.val);
		inOrderPrint(root.right);
	}
}
