import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // get the most to least frequent tasks
		Integer[] task2Occ = new Integer[26];
		Arrays.fill(task2Occ, 0);
		for (char task: tasks) {
			task2Occ[task - 'A']++;
		}
		Arrays.sort(task2Occ, Collections.reverseOrder());
		int maxFreq = task2Occ[0];
		int nIdle = (maxFreq - 1) * n;

		for (int i=1; i<task2Occ.length; i++) {
			int freq = task2Occ[i];
			if (freq == 0) { break; }
			nIdle -= Math.min(maxFreq-1, freq);
			if (nIdle < 0) {
				nIdle = 0;
				break;
			}
		}

		return tasks.length + nIdle;
    }
}
