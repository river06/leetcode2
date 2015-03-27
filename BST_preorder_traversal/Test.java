import java.util.*;

public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<Integer> ret = new LinkedList<Integer>();
		ret = solver.preorderTraversal(root);
		System.out.println(ret.toString() );
	}
}
		
		