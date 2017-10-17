/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public List<Integer> top10;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *         top10 = new ArrayList<Integer>();
 *     }
 * }
 */
import java.util.*;

public class TrieService {

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    /**
	 * @param word a string
	 * @param frequency an integer
	 */
    public void insert(String word, int frequency) {
		TrieNode cur = root;
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new TrieNode());
			}

			cur = cur.children.get(c);
			updateTop(cur.top10, frequency, 10);
		}
    }

	private void updateTop(List<Integer> top10, int frequency, int n) {
		int i=0;
		for (i=0; i<top10.size(); i++) {
			if (top10.get(i) <= frequency) {
				break;
			}
		}

		top10.add(i, frequency);
		if (top10.size() > n) {
			top10.remove(top10.size()-1);
		}
	}
 }
