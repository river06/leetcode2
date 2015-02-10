public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
//		root.right = new TreeNode(1);
		boolean ret = solver.isValidBST(root);
		System.out.println(ret);
	}
}