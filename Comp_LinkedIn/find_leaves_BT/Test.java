import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] vals = {1, 2, -1, -1, -1};
		int[] vals = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
		TreeNode root = TreeNode.buildTree(vals);
		TreeNode.printTree(root);

		List<List<Integer>> ret = solver.findLeaves(root);
		for (List<Integer> level: ret) {
			System.out.println(level);
		}
	}
}
