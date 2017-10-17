import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		TrieNode root = new TrieNode();
		root.children.put('a', new TrieNode());
		
		String str = solver.serialize(root);

		System.out.println(str);

		TrieNode r2 = solver.deserialize(str);

		String str2 = solver.serialize(r2);

		System.out.println(str2);
	}
}
