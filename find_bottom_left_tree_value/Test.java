import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] pre = {2,1,-1,-1,3,-1,-1};
		//int[] pre = {1,2,4,-1,-1,-1,3,5,7,-1,-1,-1,6,-1,-1};
		//int[] pre = {3,1,0,-1,-1,2,-1,-1,5,4,-1,-1,6,-1,-1};
		//int[] pre = {3,1,0,-1,-1,2,-1,3,-1,-1,5,4,-1,-1,6,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		int ret = solver.findBottomLeftValue(root);

		System.out.println(ret);
	}
}
