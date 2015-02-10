public class Test {
	public static void main(String[] args) {
		//Solution solver = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		BSTIterator i = new BSTIterator(root);
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
	}
}