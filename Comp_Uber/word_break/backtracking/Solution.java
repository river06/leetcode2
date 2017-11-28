import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // special case
		if (s.length() == 0) { return true; }
		if (wordDict == null || wordDict.size() == 0) { return false; }
		Set<String> wordSet = new HashSet<String>();
		for (String word: wordDict) { wordSet.add(word); }
		return backTrack(s, 0, wordSet);
    }

	private boolean backTrack(String s, int idx, Set<String> wordSet) {
		// base case
		if (idx >= s.length()) { return true; }
		for (int i=idx; i<s.length(); i++) {
			String tmp = s.substring(idx, i+1);
			if (wordSet.contains(tmp)) {
				boolean isFound = backTrack(s, i+1, wordSet);
				if (isFound) { return true; }
			}
		}
		return false;
	}
}
