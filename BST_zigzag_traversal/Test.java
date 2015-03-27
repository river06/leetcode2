import java.util.*;

public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(34);
		root.left.left = new TreeNode(31);
		root.left.right = new TreeNode(32);

		List<List<Integer>> ret = solver.zigzagLevelOrder(root);
		for(int i=0; i<ret.size(); i++) {
			System.out.println(ret.get(i).toString() );
		}
	}
}
	