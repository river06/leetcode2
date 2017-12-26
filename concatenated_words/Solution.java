import java.util.*;
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<String>();
		for (String word: words) {
			wordSet.add(word);
		}
		List<String> ret = new LinkedList<String>();
		for (String word: words) {
			if (canConcatenate(word, wordSet)) {
				ret.add(word);
			}
		}
		return ret;
    }

	private boolean canConcatenate(String word, Set<String> dict) {
		boolean[] dp = new boolean[word.length()+1];
		dp[0] = true;
		int count = 0;
		for (int r=1; r<=word.length(); r++) {
			for (int l=0; l<r; l++) {
				if (dp[l] && dict.contains(word.substring(l, r))) {
					dp[r] = true;
					if (r != word.length()) {
						break;
					} else {
						count++;
					}
				}
			}
		}
		return dp[word.length()] && count > 1;
	}
}
