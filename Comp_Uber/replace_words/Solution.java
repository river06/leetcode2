import java.util.*;
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Map<Integer, HashSet<String>> length2Words = new HashMap<Integer, HashSet<String>>();
		for (String word: dict) {
			int wordLength = word.length();
			if (!length2Words.containsKey(wordLength)) {
				length2Words.put(wordLength, new HashSet<String>());
			}
			length2Words.get(wordLength).add(word);
		}

		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (String word: words) {
			String curWord = word;
			for (int i=0; i<word.length(); i++) {
				if (length2Words.containsKey(i+1) &&
					length2Words.get(i+1).contains(word.substring(0, i+1))) {
					curWord = word.substring(0, i+1);
					break;
				}
			}
			sb.append(sb.length() == 0 ? curWord : " " + curWord);
		}

		return sb.toString();
    }
}
