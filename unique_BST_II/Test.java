import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 3;
		ArrayList<TreeNode> ret = solver.generateTrees(n);

		for(int i=0; i<ret.size(); i++) {
			TreeNode.printTree( ret.get(i) );
		}
	}
}