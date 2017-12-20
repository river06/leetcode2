import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
		//int[] pre = {3,9,4, -1,-1,0,-1,-1,8,1,-1,-1,7,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);

		TreeNode.printTree(root);

		List<List<Integer>> ret = solver.verticalOrder(root);

		for (List<Integer> layer: ret) {
			System.out.println(layer);
		}
	}
}
