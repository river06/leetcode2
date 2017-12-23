import java.util.*;
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) { return false; }
		
        UnionFind uf = new UnionFind();

		// construct union find
		for (String[] pair: pairs) {
			if (!uf.contains(pair[0])) { uf.makeSet(pair[0]); }
			if (!uf.contains(pair[1])) { uf.makeSet(pair[1]); }
			uf.union(pair[0], pair[1]);
		}

		Map<String, Integer> word2Freq = new HashMap<String, Integer>();

		// construction hash map for words1
		for (String word: words1) {
			if (!uf.contains(word)) {
				uf.makeSet(word);
			}
			String key = uf.find(word);
			word2Freq.put(key, word2Freq.getOrDefault(key, 0) + 1);
		}

		// sorting key for words2
		for (String word: words2) {
			if (!uf.contains(word)) {
				return false;
			}
			String key = uf.find(word);
			word2Freq.put(key, word2Freq.getOrDefault(key, 0) - 1);
			if (word2Freq.get(key) < 0) {
				return false;
			}
		}

		return true;
    }
	class UnionFind {
		Map<String, String> word2Parent = new HashMap<String, String>();
		void makeSet(String str) {
			if (!word2Parent.containsKey(str)) {
				word2Parent.put(str, str);
			}
		}

		boolean contains(String str) {
			return word2Parent.containsKey(str);
		}

		String find(String str) {
			if (str.equals(word2Parent.get(str))) {
				return str;
			}

			word2Parent.put(str, find(word2Parent.get(str)));
			return word2Parent.get(str);
		}

		void union(String str1, String str2) {
			String r1 = find(str1);
			String r2 = find(str2);
			if (!r1.equals(r2)) {
				word2Parent.put(r1, r2);
			}
		}
	}
}
