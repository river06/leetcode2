import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] nums = {3,2,1,6,0,5};
		//int[] nums = {1};
		int[] nums = {1,2};
		TreeNode root = solver.constructMaximumBinaryTree(nums);

		TreeNode.printTree(root);
	}
}
