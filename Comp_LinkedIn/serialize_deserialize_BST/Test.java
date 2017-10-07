import java.util.*;
public class Test {
	public static void main(String[] args) {
		Codec solver = new Codec();
		//int[] pre = {0};
		//int[] pre = {1,0};
		//int[] pre = {1,0,-1,-1,2};
		int[] pre = {5,2,1,-1,-1,3,-1,4,-1,-1,8,6,-1,7,-1,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		String data = solver.serialize(root);

		System.out.println(data);

		TreeNode tree = solver.deserialize(data);

		TreeNode.printTree(tree);
		
	}
}
