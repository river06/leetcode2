public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		
		TreeNode head = new TreeNode(0);

		head.left = new TreeNode(2);
		head.right = new TreeNode(2);
		head.left.right = new TreeNode(3);
		head.right.left = new TreeNode(3);

		boolean ret = solver.isSymmetric(head);

		System.out.println(ret);
		
			// TreeNode.printTree( head );
	}
}