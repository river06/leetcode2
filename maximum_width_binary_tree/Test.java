import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] pre = {1,3,5,-1,-1,3,-1,-1,2,-1,9,-1,-1};
		//int[] pre = {1,3,5,-1,-1,3,-1,-1,-1};
		//int[] pre = {1,3,5,-1,-1,-1,2,-1,-1};
		//int[] pre = {1,2,5,6,-1,-1,-1,-1,2,-1,9,-1,7,-1,-1};
		int[] pre = {2, 1, 3, -1, -1, -1, 4, 5, -1, -1, -1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		int ret = solver.widthOfBinaryTree(root);
		System.out.println(ret);
		
	}
}
