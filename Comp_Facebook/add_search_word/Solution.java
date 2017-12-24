class WordDictionary {
	private Trie dict;
    /** Initialize your data structure here. */
    public WordDictionary() {
        dict = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        dict.insert(word);
    }
    
    /**
	 * Returns if the word is in the data structure.
	 * A word could contain the dot character '.' to represent any one letter.
	 */
    public boolean search(String word) {
        return dict.search(word);
    }

	class Trie {
		private TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode p = root;
			for (int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				if (p.children[c-'a'] == null) {
					p.children[c-'a'] = new TrieNode(); 
				}
				p = p.children[c-'a'];
			}
			p.isWordEnd = true;
		}

		public boolean search(String word) {
			return dfs(word, this.root, 0);
		}

		private boolean dfs(String word, TrieNode root, int idx) {
			if (root == null) {
				return false;
			}
			
			if (idx == word.length()) {
				return root.isWordEnd;
			}
			
			char c = word.charAt(idx);

			if (c == '.') {
				for (int i=0; i<root.children.length; i++) {
					boolean tmp = dfs(word, root.children[i], idx+1);
					if (tmp) {
						return true;
					}
				}
				return false;
			} else {
				return dfs(word, root.children[c-'a'], idx+1);
			}

		}
	}

	class TrieNode {
		boolean isWordEnd;
		TrieNode[] children;
		public TrieNode () {
			this.isWordEnd = false;
			this.children = new TrieNode[26]; // 26 letters
		}
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
