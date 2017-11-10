import java.util.*;
class WordDistance {
	Map<String, List<Integer>> word2Idx;

    public WordDistance(String[] words) {
        word2Idx = new HashMap<String, List<Integer>>();
		for (int i=0; i<words.length; i++) {
			String word = words[i];
			if (!word2Idx.containsKey(word)) {
				word2Idx.put(word, new LinkedList<Integer>());
			}
			word2Idx.get(word).add(i);
		}
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> idx1 = word2Idx.get(word1);
		List<Integer> idx2 = word2Idx.get(word2);

		int ret = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;

		while (i < idx1.size() && j < idx2.size()) {
			int p1 = idx1.get(i);
			int p2 = idx2.get(j);
			if (p1 < p2) {
				ret = Math.min(ret, p2 - p1);
				i++;
			} else {
				ret = Math.min(ret, p1 - p2);
				j++;
			}
		}
		return ret;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
