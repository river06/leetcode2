import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] preOrder = {5,3,11,7,2,8,13,4,5,1};
		int[] inOrder = {7,11,2,3,5,13,8,5,4,1};
		int sum = 22;
		
		TreeNode root = TreeNode.buildTree(preOrder, inOrder);

		TreeNode.printTree(root);

		List<List<Integer>> ret = solver.pathSum(root, sum);

		for (List<Integer> path: ret) {
			System.out.println(path);
		}
	}
}
