import java.util.*;
public class Test {
	public static void main(String[] args) {
		//Solution solver = new Solution();
		int[] pre = {1,3,5,-1,-1,3,-1,-1,2,-1,9,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);

		TreeNode.printTree(root);
	}
}
