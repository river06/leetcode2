/**
 * Definition of TrieNode:
 */
import java.util.*;
public class TrieNode {
    public NavigableMap<Character, TrieNode> children;
    public List<Integer> top10;
	public TrieNode() {
		children = new TreeMap<Character, TrieNode>();
		top10 = new ArrayList<Integer>();
	}
}

