class Solution {
    public int numSquares(int n) {
        if (n <= 0) { return 0; }
		int[] nSquare = new int[n+1];
		for (int i=1; i<=n; i++) {
			if (i*i <= n) {
				nSquare[i*i] = 1;
			}
		}

		for (int i=1; i<=n; i++) {
			if (nSquare[i] == 1) { continue; }

			int minSquare = Integer.MAX_VALUE;

			for (int j=1; j<=i/2; j++) {
				minSquare = Math.min(minSquare, nSquare[j] + nSquare[i-j]);
			}
			nSquare[i] = minSquare;
		}

		return nSquare[n];
    }
}
