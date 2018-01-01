class Solution {
    public int findMinMoves(int[] machines) {
		int n = machines.length;
        int[] sum = new int[n];
		for (int i=0; i<n; i++) {
			if (i > 0) {
				sum[i] += sum[i-1];
			}
			sum[i] += machines[i];
		}
		if (sum[n-1] % n != 0) { return -1; }
		int target = sum[n-1] / n;
		
		int[] diffL = new int[n];
		int[] diffR = new int[n];

		for (int i=0; i<n; i++) {
			diffL[i] = sum[i] - target * (i+1);
		}

		for (int i=n-1; i>=0; i--) {
			int sumR = sum[n-1] - ((i>0) ? sum[i-1] : 0);
			diffR[i] = sumR - target * (n-i);
		}

		int ret = 0;
		for (int i=0; i<n; i++) {
			int nl = i > 0 ? Math.max(-diffL[i-1], 0) : 0;
			int nr = i < n-1 ? Math.max(-diffR[i+1], 0) : 0;
			ret = Math.max(ret, nl + nr);
		}

		return ret;
    }
}
