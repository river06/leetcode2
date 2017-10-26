class Solution {
    public double myPow(double x, int n) {
        if (x == 0) { return n==0 ? 1 : 0; }
		double ret = 1;
		if (n == Integer.MIN_VALUE) {
			n++;
			ret *= 1/x;
		}

		if (n < 0) {
			n = -n;
			x = 1/x;
		}

		while (n > 0) {
			if ((n & 1) == 1) {
				ret *= x;
			}
			n >>= 1;
			x*=x;
		}
		return ret;
    }
}
