import java.util.*;
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
		Set<String> seen = new HashSet<String>();
		int maxLength = 0;
		int maxIdx = -1;
		for (int i=0; i<words.length; i++) {
			String word = words[i];
			if (word.length() == 1 ||
				seen.contains(word.substring(0, word.length()-1))) {

				if (word.length() > maxLength) {
					maxLength = word.length();
					maxIdx = i;
				}
				
				seen.add(word);
			}
		}

		return words[maxIdx];
    }
}
