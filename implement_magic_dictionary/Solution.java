class MagicDictionary {
	private Set<String> dict;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.dict = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word: dict) {
			this.dict.add(word);
		}
    }
    
    /**
	 * Returns if there is any word in the trie that equals to the given word
	 * after modifying exactly one character
	 */
    public boolean search(String word) {
		StringBuilder sb = new StringBuilder(word);
        for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			for (char x = 'a'; x <= 'z'; x++) {
				if (x != c) {
					sb.setCharAt(i, x);
					if (this.dict.contains(sb.toString())) {
						return true;
					}
				}
			}
			sb.setCharAt(i, c);
		}
		return false;
    }
}
