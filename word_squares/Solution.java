import java.util.*;

class Solution {
	List<List<String>> ret;
	Trie dict;
	int squareLength;
    public List<List<String>> wordSquares(String[] words) {
		this.ret = new LinkedList<List<String>>();
        this.dict = new Trie();
		for (String word: words) {
			this.dict.insert(word);
		}

		this.squareLength = words[0].length();
		List<String> square = new LinkedList<String>();
		for (String word: words) {
			square.add(word);
			backTrack(square);
			square.remove(0);
		}

		return this.ret;
    }

	private void backTrack (List<String> square) {
		if (square.size() == this.squareLength) {
			this.ret.add(new ArrayList<String>(square));
			return;
		}

		String prefix = getPrefix(square);

		List<String> words = this.dict.searchPrefix(prefix);

		for (String word: words) {
			square.add(word);
			backTrack(square);
			square.remove(square.size()-1);
		}
	}

	private String getPrefix(List<String> square) {
		StringBuilder sb = new StringBuilder();
		int i = square.size();
		for (String word: square) {
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}

	class TrieNode {
		TrieNode[] children;
		List<String> words;
		TrieNode () {
			this.children = new TrieNode[26];
			this.words = new LinkedList<String>();
		}
	}

	class Trie {
		TrieNode root;

		Trie () {
			this.root = new TrieNode();
		}

		List<String> searchPrefix (String prefix) {
			List<String> ret = new ArrayList<String>();
			TrieNode p = this.root;
			for (int i=0; i<prefix.length(); i++) {
				int idx = prefix.charAt(i) - 'a';
				if (p.children[idx] == null) {
					return ret;
				}
				p = p.children[idx];
			}

			return p.words;
		}
		
		void insert (String word) {
			TrieNode p = this.root;
			for (int i=0; i<word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (p.children[idx] == null) {
					p.children[idx] = new TrieNode();
				}

				p = p.children[idx];
				p.words.add(word);
			}
		}
	}
}
