package hw;

import java.util.*;
import hw.BST_level_order_traversal.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		
		int[] inorder = {4,2,5,1,6,3,7};
		int[] postorder = {4,5,2,6,7,3,1};
		TreeNode root = solver.buildTree(inorder, postorder);

		hw.BST_level_order_traversal.Solution solver2 = new hw.BST_level_order_traversal.Solution();
		List<List<Integer>> ret2 = solver2.levelOrder(root);
		for(List<Integer> level : ret2) {
			System.out.println( level.toString() );
		}
	}
}
