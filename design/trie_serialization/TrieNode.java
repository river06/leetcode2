/**
 * Definition of TrieNode:
 */
import java.util.*;
public class TrieNode {
	public NavigableMap<Character, TrieNode> children;
	public TrieNode() {
		children = new TreeMap<Character, TrieNode>();
	}
}
 
