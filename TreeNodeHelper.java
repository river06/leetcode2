import java.util.*;

public class TreeNodeHelper {
	public static void printTree(TreeNode root) {
		List<List<Integer>> tree = levelOrderTraversal(root);
		for (List<Integer> level: tree) {
			System.out.println(level);
		}
	}
	
	private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        // use two queues to maintain information
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		List<Integer> ret_level = new LinkedList<Integer>();

		if(root == null) return ret;
		
		Queue<TreeNode> this_level = new LinkedList<TreeNode>();
		Queue<TreeNode> next_level = new LinkedList<TreeNode>();

		this_level.add(root);
		while( !this_level.isEmpty() || !next_level.isEmpty() ) {
			if( this_level.isEmpty() ) {
				this_level = next_level;
				next_level = new LinkedList<TreeNode>();
				ret.add( ret_level );
				ret_level = new LinkedList<Integer>();
			} else {
				TreeNode p = this_level.remove();
				if( p.left != null ) next_level.add(p.left);
				if( p.right != null ) next_level.add(p.right);
				ret_level.add( p.val);
			}
		}
		ret.add(ret_level);
		return ret;
    }

	public static TreeNode buildTree(int[] preorder) {

	}

	private static TreeNode deserialize(int[] preorder, int idx) {
		if (idx ==
			
