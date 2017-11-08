import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS algorithm
		int length = 0;
		Queue<String> curWords = new LinkedList<String>();
		Set<String> allWords = new HashSet<String>();
		for (String str: wordList) {
			allWords.add(str);
		}

		curWords.add(beginWord);

		while (!curWords.isEmpty()) {
			int numCurWords = curWords.size();
			length++;
			for (int i=0; i<numCurWords; i++) {
				String curWord = curWords.poll();
				if (curWord.equals(endWord)) {
					return length;
				}
				List<String> nextWords = findNextWords(allWords, curWord);
				for (String nextWord: nextWords) {
					curWords.offer(nextWord);
				}
			}
		}
		return 0;
    }

	private List<String> findNextWords(Set<String> allWords, String curWord) {
		List<String> nextWords = new LinkedList<String>();
		char[] curWordArr = curWord.toCharArray();
		for (int i=0; i<curWordArr.length; i++) {
			char oriC = curWordArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				curWordArr[i] = c;
				String nextWord = new String(curWordArr);
				if (allWords.contains(nextWord)) {
					nextWords.add(nextWord);
					allWords.remove(nextWord);
				}
			}
			curWordArr[i] = oriC;
		}
		return nextWords;
	}
}
