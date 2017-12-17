import java.util.*;
class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) { return s; }
		if (k > s.length()) { return ""; }

		// get map from character to frequency
		int[] char2Freq = new int[26];
		for (int i=0; i<s.length(); i++) {
			char2Freq[s.charAt(i)-'a']++;
		}
		int[] maxFreqChar = getMaxFreqChar(char2Freq);
		int maxFreq = maxFreqChar[1];
		int nEmpty = (maxFreq-1) * k;
			
		// try to rearrange and determine if it is possible
		List<StringBuilder> sbList = new ArrayList<StringBuilder>();
		for (int i=0; i<maxFreq; i++) {
			sbList.add(new StringBuilder());
		}

		int idx = 0;
		while (maxFreqChar[1] > 0) {
			if (maxFreqChar[1] == maxFreq) {
				// add from 0 to maxFreq
				for (int i=0; i<maxFreq; i++) {
					sbList.get(i).append((char) maxFreqChar[0]);
				}
			} else {
				for (int i=0; i<maxFreqChar[1]; i++) {
					sbList.get(idx).append((char) maxFreqChar[0]);
					idx = (idx + 1) % (maxFreq-1);
				}
			}
			nEmpty -= Math.min(maxFreq-1, maxFreqChar[1]);

			// get next maxFrequent char
			maxFreqChar = getMaxFreqChar(char2Freq);
		}
		// get final result
		if (nEmpty > 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<maxFreq; i++) {
				sb.append(sbList.get(i));
			}
			return sb.toString();
		}
    }

	private int[] getMaxFreqChar(int[] char2Freq) {
		int maxFreq = 0;
		int maxIdx = -1;
		for (int i=0; i<char2Freq.length; i++) {
			if (char2Freq[i] > maxFreq) {
				maxFreq = char2Freq[i];
				maxIdx = i;
			}
		}
		if (maxFreq > 0) { char2Freq[maxIdx] = 0; }
			
		return new int[] {maxIdx + 'a', maxFreq};
	}
}
