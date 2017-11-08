import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// corner cases
		List<List<String>> ladders = new LinkedList<List<String>>();
		if (beginWord == null || endWord == null) { return ladders; }

		// BFS to search for the minimum length and build up the back mapping		
		Set<String> wordSet = new HashSet<String>();
		for (String word: wordList) { wordSet.add(word); }

		Map<String, Set<String>> preWords = new HashMap<String, Set<String>>();
		boolean isLadderFound = false;
		Set<String> curLevel = new HashSet<String>();
		curLevel.add(beginWord);

		while(!curLevel.isEmpty() && !isLadderFound) {
			Set<String> nextLevel = new HashSet<String>();
			Iterator<String> it = curLevel.iterator();
			while (it.hasNext()) {
				String curWord = it.next();
				if (curWord.equals(endWord)) {
					isLadderFound = true;
				}
				findNextWords(curWord, wordSet, preWords, nextLevel);
			}
			wordSet.removeAll(nextLevel);
			curLevel = nextLevel;
		}
		
        // retrieve all the paths
		if (!isLadderFound) { return ladders; }
		List<String> ladder = new LinkedList<String>();
		ladder.add(endWord);
		dfs(ladder, ladders, preWords, beginWord, endWord);
		return ladders;
    }

	private void dfs(List<String> ladder, List<List<String>> ladders,
					 Map<String, Set<String>> preWords, 
					 String beginWord, String preWord) {
		// base cases
		if (preWord.equals(beginWord)) {
			List<String> ret = new LinkedList<String>(ladder);
			Collections.reverse(ret);
			ladders.add(ret);
			return;
		}

		for (String nextWord: preWords.get(preWord)) {
			ladder.add(nextWord);
			dfs(ladder, ladders, preWords, beginWord, nextWord);
			ladder.remove(ladder.size()-1);
		}
	}
		

	private void findNextWords(String curWord, Set<String> wordSet, 
							   Map<String, Set<String>> preWords,
							   Set<String> nextLevel) {
		for (int i=0; i<curWord.length(); i++) {
			StringBuilder sb = new StringBuilder(curWord);
			for (char c = 'a'; c <= 'z'; c++) {
				sb.setCharAt(i, c);
				String nextWord = sb.toString();
				if (wordSet.contains(nextWord)) {
					if (!preWords.containsKey(nextWord)) {
						preWords.put(nextWord, new HashSet<String>());
					}
					preWords.get(nextWord).add(curWord);
					nextLevel.add(nextWord);
				}
			}
		}
	}
}
