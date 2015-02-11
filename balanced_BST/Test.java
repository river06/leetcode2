public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(0);
		boolean ret = solver.isBalanced( root );
		System.out.println( ret );
	}
}