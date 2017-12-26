class MapSum {

    /** Initialize your data structure here. */
	private Trie dict;
    public MapSum() {
        this.dict = new Trie();
    }
    
    public void insert(String key, int val) {
        this.dict.insert(key, val);
    }
    
    public int sum(String prefix) {
        return this.dict.search(prefix, true);
    }

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		int sum = 0;
		int val = 0;
	}

	class Trie {
		private TrieNode root = new TrieNode();

		void insert(String word, int val) {
			int delta = val - search(word, false);
			TrieNode p = this.root;

			for (int i=0; i<word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (p.children[idx] == null) {
					p.children[idx] = new TrieNode();
				}
				p = p.children[idx];
				p.sum += delta;
			}
			p.val = val;
		}

		int search(String word, boolean isSum) {
			TrieNode p = this.root;
			for (int i=0; i<word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (p.children[idx] == null) {
					return 0;
				}
				p = p.children[idx];
			}
			return isSum ? p.sum : p.val;
		}
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
