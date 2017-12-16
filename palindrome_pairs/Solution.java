import java.util.*;
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (words == null || words.length < 2) {
			return ret;
		}

		// make a map from words to index
		Map<String, Integer> word2Idx = new HashMap<String, Integer>();
		for (int i=0; i<words.length; i++) {
			word2Idx.put(words[i], i);
		}
		for (int i=0; i<words.length; i++) {
			String word = words[i];
			for (int l=0; l<=word.length(); l++) {
				// find pairs by adding words to the left of current word
				if (l != 0 && isPalindrome(word, 0, l-1)) {
					StringBuilder sb = new StringBuilder(
						word.substring(l, word.length()));
					String target = sb.reverse().toString();
					if (word2Idx.containsKey(target) && word2Idx.get(target) != i) {
						addResult(ret, word2Idx.get(target), i);
					}
				}
				// find paris by adding words to the right of current word
				if (isPalindrome(word, word.length()-l, word.length()-1)) {
					StringBuilder sb = new StringBuilder(
						word.substring(0, word.length()-l));
					String target = sb.reverse().toString();
					if (word2Idx.containsKey(target) && word2Idx.get(target) != i) {
						addResult(ret, i, word2Idx.get(target));
					}
				}
			}
		}
		return ret;
    }

	private boolean isPalindrome(String word, int start, int end) {
		while (start < end) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	private void addResult(List<List<Integer>> ret, int l, int r) {		
		List<Integer> newRet = new ArrayList<Integer>(2);
		newRet.add(l);
		newRet.add(r);
		ret.add(newRet);
	}
}
