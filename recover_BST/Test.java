public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		solver.recoverTree(root);

		inOrderPrint(root);
	}

	public static void inOrderPrint(TreeNode root) {
		if(root == null) return;
		inOrderPrint(root.left);
		System.out.println(root.val);
		inOrderPrint(root.right);
	}
}