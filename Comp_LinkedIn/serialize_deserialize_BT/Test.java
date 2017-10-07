import java.util.*;
public class Test {
	public static void main(String[] args) {
		Codec solver = new Codec();
		int[] pre = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
		TreeNode root = TreeNode.buildTree(pre);
		TreeNode.printTree(root);

		String data = solver.serialize(root);

		System.out.println(data);

		TreeNode tree = solver.deserialize(data);

		TreeNode.printTree(tree);
		
	}
}
