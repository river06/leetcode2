import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // base case
		if (s.length() == 0) { return true; }
		if (wordDict == null || wordDict.size() == 0) { return false; }

		Set<String> wordSet = new HashSet<String>();
		for (String word: wordDict) { wordSet.add(word); }
		
		// DP algorithm
		boolean[] canBreak = new boolean[s.length()+1];
		canBreak[0] = true;

		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<=i; j++) {
				if (canBreak[j]) {
					if (wordSet.contains(s.substring(j, i+1))) {
						canBreak[i+1] = true;
						continue;
					}
				}
			}
		}
		return canBreak[s.length()];
    }
}
