class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plate2Freq = getFrequency(licensePlate);
		String ret = "";
		int minLength = Integer.MAX_VALUE;
		for (String word: words) {
			int[] word2Freq = getFrequency(word);
			if (word.length() < minLength && isContained(plate2Freq, word2Freq)) {
				minLength = word.length();
				ret = word;
			}
		}
		return ret;
    }

	private boolean isContained(int[] plate, int[] word) {
		for (int i=0; i<plate.length; i++) {
			if (plate[i] > word[i]) {
				return false;
			}
		}
		return true;
	}

	private int[] getFrequency(String word) {
		int[] freq = new int[26];
		for (int i=0; i<word.length(); i++) {
			int c = word.charAt(i);
			if ('A' <= c && c <= 'Z') {
				c = c - 'A' + 'a';
			}
			if ('a' <= c && c <= 'z') {
				freq[c - 'a']++;
			}
		}
		return freq;
	}
}
