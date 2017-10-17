/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */

import java.util.*;

class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        if (root == null) { return null; };
		StringBuilder sb = new StringBuilder();

		serial(root, sb);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
    }

	private void serial(TrieNode root, StringBuilder sb) {
		if (root == null) { return; }
		
		for (Map.Entry<Character, TrieNode> child: root.children.entrySet()) {
			sb.append(child.getKey() + ",");
			serial(child.getValue(), sb);
		}
		
		sb.append("),");
		
		return;
	}

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
		if (data == null) { return null; }
        String[] nodes = data.split(",");

		TrieNode root = new TrieNode();
		int[] idx = new int[1];
		deserial(root, nodes, idx);

		return root;
    }

	private void deserial(TrieNode root, String[] nodes, int[] idx) {

		while (idx[0] < nodes.length && !nodes[idx[0]].equals(")")) {
		    TrieNode child = new TrieNode();
		
		    root.children.put(nodes[idx[0]].charAt(0), child);

		    idx[0] += 1;
			
		    deserial(child, nodes, idx);
		}
		
		idx[0] += 1;
		return;
		
	}
}
