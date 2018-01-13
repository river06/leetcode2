import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] char2Freq = new Integer[26];
		Arrays.fill(char2Freq, 0);
		for (char c: tasks) {
			char2Freq[c-'A']++;
		}

		Arrays.sort(char2Freq, Collections.reverseOrder());

		int nIdle = (char2Freq[0]-1) * n;
		int nInterval = char2Freq[0];
		for (int i=1; i<char2Freq.length; i++) {
			nInterval += char2Freq[i];
			nIdle -= Math.min(char2Freq[i], char2Freq[0]-1);
		}
		nInterval += Math.max(0, nIdle);
		return nInterval;
    }
}
