import java.util.*;

class TrieNode {
    // Initialize your data structure here.
	boolean isWordEnd;
	TrieNode[] children;
    public TrieNode() {
        isWordEnd = false;
		children = new TrieNode[26]; // default is null
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
		TrieNode pt = root;
        for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if( pt.children[c-'a'] == null) {
				pt.children[c-'a'] =  new TrieNode();
			}
			pt = pt.children[c-'a'];
		}
		pt.isWordEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode pt = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if( pt.children[c-'a'] == null) return false;
			pt = pt.children[c-'a'];
		}
		return (pt.isWordEnd);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode pt = root;
		for(int i=0; i<prefix.length(); i++) {
			char c = prefix.charAt(i);
			if( pt.children[c-'a'] == null) return false;
			pt = pt.children[c-'a'];
		}
		return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
