import java.util.*;

public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		TreeNode root = new TreeNode(1);

		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<List<Integer>> ret = solver.levelOrderBottom(root);
		for(int i=0; i<ret.size(); i++) {
			System.out.println(ret.get(i).toString() );
		}
	}
}
		
		