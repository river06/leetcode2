class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0) {
			return 0;
		}
		int[] ret = new int[n];
		int[] p = new int[primes.length];

		ret[0] = 1;
		for (int i=1; i<n; i++) {
			int minVal = Integer.MAX_VALUE;
			for (int j = 0; j<primes.length; j++) {
				if (ret[p[j]] * primes[j] < minVal) {
					minVal = ret[p[j]] * primes[j];
				}
			}
			for (int j = 0; j<primes.length; j++) {
				if (ret[p[j]] * primes[j] == minVal) {
					p[j]++;
				}
			}
			ret[i] = minVal;
		}

		return ret[n-1];
    }
}
