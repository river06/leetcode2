import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // sort envelopes by width. Height larger comes first
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				int ret = Integer.compare(a[0], b[0]);
				if (ret == 0) {
					ret = Integer.compare(b[1], a[1]);
				}
				return ret;
			}
		});

		for (int i=0; i<envelopes.length; i++) {
			System.out.println( Arrays.toString(envelopes[i]) );
		}
		
		// longest increasing sub sequence algorithm DP
		int[] st = new int[envelopes.length];
		int dollNum = 0;
		for (int i=0; i<envelopes.length; i++) {
			int idx = Arrays.binarySearch(st, 0, dollNum, envelopes[i][1]);
			if (idx < 0) {
				idx = -(idx+1);
			}
			st[idx] = envelopes[i][1];
			if (idx == dollNum) {
				dollNum++;
			}
		}

		return dollNum;
    }
}
