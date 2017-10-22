class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) { return 0; }
		int[] ret = new int[n];

		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		ret[0] = 1;
		for (int i=1; i<n; i++) {
			int min = Math.min(Math.min(ret[p2]*2, ret[p3]*3), ret[p5]*5);
			ret[i] = min;
			if (ret[p2]*2 == min) {	p2++; }
			if (ret[p3]*3 == min) { p3++; }
			if (ret[p5]*5 == min) { p5++; }

		}
		return ret[n-1];
    }
}
